package com.neo.drools;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import deserializer.AlarmDeserializer;
import dbconnection.*;
import com.neo.drools.entity.ExtendedAlarm;


import java.util.*;



public class SampleMatching {

    public static final void main(final String[] args) {
        KieServices ks = KieServices.Factory.get();

        KieContainer kc = ks.getKieClasspathContainer();

        execute( kc );
    }

    public static void execute( KieContainer kc ) {
        
        
        try {
            KieSession ksession = kc.newKieSession("AlarmKS");
        } catch (Exception e) {
            System.out.println("Error deserializing alarms: " + e.getMessage());
            e.printStackTrace();
        }
        ksession.setGlobal( "list",
                            new ArrayList<Object>() );

        ksession.addEventListener( new DebugAgendaEventListener() );
        ksession.addEventListener( new DebugRuleRuntimeEventListener() );

        List<ExtendedAlarm> alarms = new ArrayList<>();
        try {
            alarms = AlarmDeserializer.deserializeAlarms(MongoConnection.getDBCursor());
        } catch (Exception e) {
            System.out.println("Error deserializing alarms: " + e.getMessage());
            e.printStackTrace();
        }

        if (alarms == null) {
            System.out.println("Alarms list is null");
        } else {
            for (ExtendedAlarm alarm : alarms) {
                if (alarm == null) {
                    System.out.println("Found null alarm");
                } else {
                    ksession.insert(alarm);
                }
            }
        }

        try {
            ksession.fireAllRules();
        } catch (Exception e) {
            System.out.println("Error firing rules: " + e.getMessage());
            e.printStackTrace();
        }

        int disPrioritizedCount = 0;
        System.out.println("ID of Roots:\n");
        for (ExtendedAlarm alarm : alarms) {
            if (alarm.getParent() == null) {
                System.out.println(alarm.getId());
                alarm.setRootCause(true);
            } else {
                disPrioritizedCount++;
            }
        }
        System.out.println("\n" + disPrioritizedCount + " alarms deprioritized.");

        ksession.dispose();
    }
}
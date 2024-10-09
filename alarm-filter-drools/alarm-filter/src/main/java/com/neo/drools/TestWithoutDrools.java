package com.neo.drools;

import java.util.ArrayList;
import java.util.List;

import com.neo.drools.entity.ExtendedAlarm;
import dbconnection.*;
import deserializer.*;

public class TestWithoutDrools {
    public static final void main(final String[] args) {
//normal execution
        List<ExtendedAlarm> alarms = new ArrayList<>();
        alarms = AlarmDeserializer.deserializeAlarms(MongoConnection.getDBCursor());
        System.out.println("reached this stage");
        for (ExtendedAlarm alarm: alarms) {
            System.out.println("Object " + alarm.getId() + " successfully read.");
        }
    }
}


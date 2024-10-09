package com.neo.drools.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class ExtendedAlarm {

    @SerializedName("_id")
    private String id;
    private String ackState;
    private String alarmChangedTime;
    private String alarmRaisedTime;
    private String eventTime;
    private String eventType;
    private boolean display;
    private boolean enabled;
    private List<String> faultDetails;
    private String faultType;
    private boolean isRootCause;
    private String managedObjectTargetType;
    private String managedObjectType;
    private String managedSubObjectTargetType = null; //only in VIM
    private Map<String,String> metadata = new HashMap<String,String>();

    @SerializedName("fault_details_replacement_mode")
    private String faultDetailsReplacementMode = null; //only in CNF
    private String objectInstanceId;
    private String objectInstanceName;
    private String perceivedSeverity;
    private boolean pinStatus;
    private String probableCause;
    private String raiseNumber;
    private String resourceId; //only in CNF
    private String subObjectInstanceId;
    private String subObjectInstanceIp;
    private String subObjectInstanceName;
    private String subObjectInstanceNameNocPro;
    private transient ExtendedAlarm parent = null;
    private transient List<ExtendedAlarm> child = null;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAckState() {
        return ackState;
    }

    public void setAckState(String ackState) {
        this.ackState = ackState;
    }

    public String getAlarmChangedTime() {
        return alarmChangedTime;
    }

    public void setAlarmChangedTime(String alarmChangedTime) {
        this.alarmChangedTime = alarmChangedTime;
    }

    public String getAlarmRaisedTime() {
        return alarmRaisedTime;
    }

    public void setAlarmRaisedTime(String alarmRaisedTime) {
        this.alarmRaisedTime = alarmRaisedTime;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public boolean isDisplay() {
        return display;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getFaultDetails() {
        return faultDetails;
    }

    public void setFaultDetails(List<String> faultDetails) {
        this.faultDetails = faultDetails;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public boolean isRootCause() {
        return isRootCause;
    }

    public void setRootCause(boolean rootCause) {
        isRootCause = rootCause;
    }

    public String getManagedObjectTargetType() {
        return managedObjectTargetType;
    }

    public void setManagedObjectTargetType(String managedObjectTargetType) {
        this.managedObjectTargetType = managedObjectTargetType;
    }

    public void setErrorCode(String errorCode) {
        this.metadata.put("errorCode", errorCode);
    }

    public String getErrorCode() {
        return metadata.get("errorCode");
    }

    public String getManagedObjectType() {
        return managedObjectType;
    }

    public void setManagedObjectType(String managedObjectType) {
        this.managedObjectType = managedObjectType;
    }

    public String getManagedSubObjectTargetType() {
        return managedSubObjectTargetType;
    }

    public void setManagedSubObjectTargetType(String managedSubObjectTargetType) {
        this.managedSubObjectTargetType = managedSubObjectTargetType;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getObjectInstanceId() {
        return objectInstanceId;
    }

    public void setObjectInstanceId(String objectInstanceId) {
        this.objectInstanceId = objectInstanceId;
    }

    public String getObjectInstanceName() {
        return objectInstanceName;
    }

    public void setObjectInstanceName(String objectInstanceName) {
        this.objectInstanceName = objectInstanceName;
    }

    public String getPerceivedSeverity() {
        return perceivedSeverity;
    }

    public void setPerceivedSeverity(String perceivedSeverity) {
        this.perceivedSeverity = perceivedSeverity;
    }

    public boolean isPinStatus() {
        return pinStatus;
    }

    public void setPinStatus(boolean pinStatus) {
        this.pinStatus = pinStatus;
    }

    public String getProbableCause() {
        return probableCause;
    }

    public void setProbableCause(String probableCause) {
        this.probableCause = probableCause;
    }

    public String getRaiseNumber() {
        return raiseNumber;
    }

    public void setRaiseNumber(String raiseNumber) {
        this.raiseNumber = raiseNumber;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getSubObjectInstanceId() {
        return subObjectInstanceId;
    }

    public void setSubObjectInstanceId(String subObjectInstanceId) {
        this.subObjectInstanceId = subObjectInstanceId;
    }

    public String getSubObjectInstanceIp() {
        return subObjectInstanceIp;
    }

    public void setSubObjectInstanceIp(String subObjectInstanceIp) {
        this.subObjectInstanceIp = subObjectInstanceIp;
    }

    public String getSubObjectInstanceName() {
        return subObjectInstanceName;
    }

    public void setSubObjectInstanceName(String subObjectInstanceName) {
        this.subObjectInstanceName = subObjectInstanceName;
    }

    public String getSubObjectInstanceNameNocPro() {
        return subObjectInstanceNameNocPro;
    }

    public void setSubObjectInstanceNameNocPro(String subObjectInstanceNameNocPro) {
        this.subObjectInstanceNameNocPro = subObjectInstanceNameNocPro;
    }

    public ExtendedAlarm getParent() {
        return parent;
    }

    public void setParent(ExtendedAlarm parent) {
        this.parent = parent;
    }

    public List<ExtendedAlarm> getChild() {
        return child;
    }

    public void addChild(ExtendedAlarm newChild) {
        this.child.add(newChild);
    }

    public ExtendedAlarm() {}

    

}

class MyBean {

    private String event;
    private Map<String, String> eventInfo = new HashMap<String, String>();

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @JsonAnyGetter
    public Map getEventInfo() {
        return eventInfo;
    }

    @JsonAnySetter
    public void setEventInfo(Object eventObject) {
        if(eventObject instanceof Map){
            this.eventInfo.putAll((Map<String, String>) eventObject);
        }
    }

    @Override
    public String toString() {
        return "MyBean [event=" + event + ", eventInfo=" + eventInfo + "]";
    }
}
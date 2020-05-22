new HyperlinkListener(){
    public void hyperlinkUpdate(HyperlinkEvent event){
        if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
            load(event.getURL().toString());
        }
    }
}
public String handleFlow(FlowEvent event) {
    String stepToGo = event.getNextStep();
    if(stepToGo.equals("typeOfPunishment")){
        detentionTypes = service.loadDetentionTypes(this.TypeOfLeaderSelectedID);
    }
}
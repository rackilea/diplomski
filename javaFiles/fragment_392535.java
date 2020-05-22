public String handleFlow(FlowEvent event) {
    String currentStepId = event.getCurrentStep();
    String stepToGo = event.getNextStep();
    if(skip)
        return "confirm";
    else
        return event.getNextStep();
    }
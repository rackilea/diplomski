public String onFlowProcess(FlowEvent event) throws Exception {
        if ((skip == true)) {
            skip = false;   //reset in case user goes back
            generatePreview();
            return CONFIRM_TAB_ID;
        } else {
            String newTab = event.getNewStep();
            if (CONFIRM_TAB_ID.equals(newTab)) {
                generatePreview();
            }

            return newTab;
        }
    }
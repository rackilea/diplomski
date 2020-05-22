engine.getLoadWorker().stateProperty().addListener((ov,oldState, newState)->{
        if(newState==State.SUCCEEDED){
            ...
            // Java to JS, send JSON list
            engine.executeScript("function addListEvents(result) {\n" +
                            "for(var i=0; i<result.data.length; i++){\n" +
                            "   addEvent(result.data[i].eventName, result.data[i].startTime, result.data[i].endTime);\n" +
                            "};\n" +
                         "}");
        }
    });
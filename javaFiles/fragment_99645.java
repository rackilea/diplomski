/* etc more code */ {
        if (theInput.equalsIgnoreCase(clues[currentPopulationRequest])) {  
            theOutput = answers[currentPopulationRequest] + " Want another? (y/n)";
            currentPopulationRequest++; 
            state = SENTPERMISSION2 ;   //sentpermssion2,  & in sentPermission2 put another
        } else {
            theOutput = "You're supposed to say \"" + 
            clues[currentPopulationRequest]  + 
            "! Try again. Request to send a state population";
            state = SENTPERMISSION;
        }
    } 

    else if (state == SENTPERMISSION2) {
        if (theInput.equalsIgnoreCase("y")) {
            theOutput = "Status logged";
            state = ANOTHER;
        } else {
            theOutput = "Bye.";       
            state = WAITING;
        }
    }

    else if (state == ANOTHER) {
        if (theInput.equalsIgnoreCase("ack")) { /* etc more code */
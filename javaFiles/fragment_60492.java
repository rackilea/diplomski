} else {
            isMatch = false;//-------------------------------------------
            for (int i = 0; i < randomWordGuess.length; i++) {
                if (randomWordGuess[i] == input) {
                    isMatch=true;//--------------------------------------
                    playerGuess[i] = input;
                } 
            }
            if(!isMatch)//------------------------------------------------
                tries++;
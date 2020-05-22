for (int i = 0; i < word2Char.length; i++){
                if (guess == word2Char[i]){
                   wordLength[i] = word2Char[i];
                   letterFound = true;
                   break;
                }else{
                    letterFound = false;
                }
            }
               if(letterFound == false){
                    wrongGuesses++;
                    System.out.println("Wrong!");
               }else{
                   correctGuesses++;
                   System.out.println("Correct!");
               }
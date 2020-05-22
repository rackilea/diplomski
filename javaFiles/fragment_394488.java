while (true) {
            // Place it here
            System.out.println("Do you like to do again");
            Boolean willContiue = false;
            while (true){
                userInput = input.next();
                if (userInput.equalsIgnoreCase("Y"));
                    willContiue = true;
                    break;
                else if (userInput.equalsIgnoreCase("N"))
                {
                    break;
                }
            }
            if (!willContinue) {
                break;
            }
        }
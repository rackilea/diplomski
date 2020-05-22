System.out.print("How many questions would you like (out of 3)? ");
        int answer = console.nextInt();
        if(answer > 3) {
            System.out.println("Sorry, that is too many.");
            check = false;
         }               
        else {
            check = true;
            qNum = answer;           
        }
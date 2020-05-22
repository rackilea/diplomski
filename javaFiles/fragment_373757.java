boolean playAgain = true;
        while(playAgain){
            //your game code here
            System.out.println("Type yes to play again, No to exit");
            Scanner answer = new Scanner(System.in);
            String s = answer.next();//this will take the answer of the user
            answer.nextLine();//this will make sure it can take next input by returning new line
            if(s.trim().toLowerCase().equals("yes")){
                playAgain = true;//if the player wants to play again, the loop will repeat
            }else{
                playAgain = false;//else the loop will exit
            }
        }
public static void main(String... s)
{
......

int score[][] = new int[playerCount][2];

        for(int i = 0 ;i < playerCount ; i++){ // finally print whatever user's roll value with all try...
        //  System.out.println(" --------- " + playerName[i] + " ------------ ");
            int playerTotalScore = 0;
            for(Die de : finalDie[i]){
            //  System.out.println(de);
                playerTotalScore += de.getFaceValue();
            }
            score[i][0] = i;
            score[i][1]=playerTotalScore;
        }

        tempDie = null;

        System.out.println("------------- Participant Score Card -------------");
        System.out.println("Index    PlayerName    Score");
        for(int i = 0 ; i < score.length ; i++){
            System.out.println(score[i][0] + "       -       " + playerName[score[i][0]] + "       -       "  + score[i][1]);
        }

        int temp[][] = new int[1][2];
        for(int i = 0 ; i< score.length; i++){
            for(int j = i+1 ; j<score.length;j++){
                if(score[i][1] < score[j][1]){
                    temp[0][0] = score[i][0];
                    temp[0][1] = score[i][1];
                    score[i][0] = score[j][0];
                    score[i][1] = score[j][1];
                     score[j][0] = temp[0][0];
                     score[j][1] = temp[0][1];
                    }
            }
        }


        System.out.println("--------------------------------------------------------");
        System.out.println("-----------------WINNER---------------------");
            System.out.println(score[0][0] + " - " + playerName[score[0][0]] + " - " + score[0][1]);
        System.out.println("--------------------------------------------------------");

} // end of main method...
public static void main (String [] args) 
 {
    String simonPattern = "";
    String userPattern = "";
    int userScore = 0;


    userScore = 0;
    simonPattern = "RRGBRYYBGY";
    userPattern  = "RRGBBRYBGY";

    String[] simons = new String[5];
    String[] users = new String[5];
    int adder=2;
    int location=0;
    for(int i=0;i<simonPattern.length();i+=2)
    {
        simons[location]=simonPattern.substring(i,adder);
        location++;
        adder+=2;
    }
    adder=2;
    location=0;
    for(int i=0;i<userPattern.length();i+=2)
    {
        users[location]=userPattern.substring(i,adder);
        location++;
        adder+=2;
    }



    for (int i = 0; i < simonPattern.length(); i++) 
    {
            if(users[i].equals(simons[i]))
                userScore++;



    }
    System.out.println(userScore);




    }
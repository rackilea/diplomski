public static void function(int targetNumber, int userGuess){
    String a = Integer.toString(targetNumber), 
           b = Integer.toString(userGuess);
    for(int i=0 ; i<4; i++){
        if(a.charAt(i) == b.charAt(i))
            System.out.print("A");
        else{
            if(a.indexOf(b.charAt(i)) == -1)
                System.out.print("I");
            else
                System.out.print("S");
        }
    }
}
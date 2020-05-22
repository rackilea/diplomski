public static void main (String [] args){
    boolean win = false;
    do{
        String computer = computerChoice();
        String user = userChoice();
        win = determineWinner(computer, user);
    }while(!win);
}
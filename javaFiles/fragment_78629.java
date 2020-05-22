public static void main(String[] args){
     boolean tie = true;
        do{
            String computer = computerChoice();
            String user = userChoice();
            tie = (computer.compareTo(user) == 0);
            determineWinner(computer, user);
        }while(tie);
}
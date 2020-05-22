public void play() {                                                        
    State s=new State(3);                                                   
    Scanner in = new Scanner (System.in);                                   
    while (s.isGameOver().equals("Not Gameover")) {                         
        int[] options = s.getAvailableMoves();                              
        s.dump();                                                           
        System.out.println ("Your options are " + Arrays.toString(options));
        int move = in.nextInt();                                            
        s.setX(move);                                                       
        int [] ScoreAndRecommendedMove=new int[2];                          
        ScoreAndRecommendedMove=s.newminimax47(0);                           
        System.out.println("Score: "+ScoreAndRecommendedMove[0]+" Position: "+ ScoreAndRecommendedMove[1]);
        s.setO(ScoreAndRecommendedMove[1]);                                 
    }                                                                       
    s.dump();                                                               
}
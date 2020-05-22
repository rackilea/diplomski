public static ArrayList<Balls> BallList = new ArrayList<Balls>();

for (Balls ball : BallList) {
    System.out.println(ball.mode);
    if (ball.mode.equals("Random")) {
         BallList.remove(ball); 
    }
}
Iterator<Balls> it = BallList.iterator();

while(it.hasNext()) {
    Balls ball = it.next();
    System.out.println(ball.mode);
    if (ball.mode.equals("Random")) {
        it.remove();
    }
}
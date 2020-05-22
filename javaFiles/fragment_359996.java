public Ball newBall(double x, double y, double velocity1, double velocity2) {
    Ball tmp = new Ball(x, y);
    tmp.setVelocity(velocity1, velocity2);
    balls.add(tmp);
    return tmp;
}
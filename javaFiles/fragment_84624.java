if (ball.getX() + ball.getR() >= rect.getTheLeft() &&
    ball.getX() - ball.getR() <= rect.getTheRight() &&
    ball.getY() - ball.getR() <= rect.getTheBottom() &&
    ball.getY() + ball.getR() >= rect.getTheTop())
{
    intersects = true;
}
public void update()
{
    r = rFromXY(speed);
    t = tFromXY(speed);

    t += turningSpeed;

    speed.setXv(xFromPolar(r,t));
    speed.setYv(yFromPolar(r,t));

    if (!touched)
    {
        x += (speed.getXv() * speed.getxDirection()); 
        y += (speed.getYv() * speed.getyDirection());
    }
}
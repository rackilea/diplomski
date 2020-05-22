// Instance variable intialized at zero.
double angle = 0.0;

// In your ActionListener timer handler increment the angle.
{
    angle += Math.toRadians(5); // 5 degrees per 100 ms = 50 degrees/second
    while (angle > 2 * Math.pi()) 
        angle -= 2 * Math.pi();  // keep angle in reasonable range.
}

public void paint(Graphics g) {
    // Just use the transform that's already in the graphics.
    Graphics2d g2 = (Graphics2d) g;
    g2.setToIdentity();
    // The code for your other transforms is garbled in my browser. Fill in here.
    g2.rotate(angle);
    g2.drawImage(arm, t, null);
}
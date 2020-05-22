int numberOfSteps = 10;
for (int i=0; i<=numberOfSteps; i++)
{
    double alpha = (double)i / numberOfSteps;
    applyMovement(alpha);
    repaint();
}
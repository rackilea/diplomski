rintegrate(a, b, steps)
{
    if(steps <= 1)
    {
        delta = b-a;
        return segment(a, delta)
    }
    else
    {
        delta = (b-a)/steps
        return segment(a, delta) + rintegrate(a+delta, b, steps-1)
    }
}
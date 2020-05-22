public float normalise()
{
    float len = (float) Math.sqrt(x * x + y * y);
    x /= len;
    y /= len;
    return len;
}
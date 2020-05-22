static int something(boolean discounted, int startzone, int endzone)
{
    if (startzone == endzone)
        return (discounted ? discount_InsideZone : insideZone);
    return (discounted ? discount_OutsideZone : outsideZone);
}
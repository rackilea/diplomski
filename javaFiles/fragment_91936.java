while (existingCircles.size() < 5)
{
    Circle circle = newRandomCircle();
    if (!circle.overlapsAny(existingCircles))
    {
        existingCircles.add(circle);
    }
}
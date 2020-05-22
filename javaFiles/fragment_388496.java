MyClass getRandomElement(MyClass[] elements)
{
    int totalWeight = 0;
    for (MyClass element : elements)
    {
       totalWeight += element.weight;
    }

    int position = new Random().nextInt(totalWeight);

    for (MyClass element : elements)
    {
       if (position < element.weight)
       {
           return element;
       }
       position -= element.weight;
    }
    throw new IllegalStateException("Should never get here");
}
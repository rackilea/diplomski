public void insert(String name, int priority)
{
    while (num != 255)
    {
        Name addName = new Name(name, priority);
        names[num] = addName;
        num++;

        while(idx != 0 || names[idx].CompareTo(names[(idx-1)/2]))
        {
            Name temp = names[idx];
            names[idx] = names[(idx-1)/2];
            names[(idx-1)/2] = temp;

            idx = (idx-1)/2;
        }
    }
}
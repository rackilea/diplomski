public void addTo(int number, long time)
{
    for (int i = 0; i < id.length; i++)
    {
        id[i] = new Node(number, time);
    }
}
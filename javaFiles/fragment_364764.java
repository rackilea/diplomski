for (int s = 1; s <= 4; s++)
{
    for (int v = 1; v <= 13; v++)
    {
        int index = (s - 1) * 13 + (v - 1);
        theDeck[index] = new Card(s, v);
    }
}
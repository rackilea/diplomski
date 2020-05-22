int index = 0;
for (int s = 1; s <= 4; s++)
{
    for (int v = 1; v <= 13; v++)
    {
        theDeck[index] = new Card(s, v);
        index++;
    }
}
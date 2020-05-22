public void addFirst(String name, int rank)
{
    Ship newShip = new Ship(name, rank);

    if (isEmpty())
    {
        newShip.next = null;
        newShip.prev = null;
        last = newShip;
        first = newShip;
    }
    else
    {
        first.prev = newShip;
        newShip.next = first;
        newShip.prev = NULL; // to ensure there are no dangling pointers
        first = newShip;
    }
}
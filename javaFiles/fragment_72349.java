public void place(int newitems, float newcost)
{
    items = newitems;
    cost = newcost;

    cost = items * cost;
}
for (int i = list.size()-1; i >= 0; i--)
{
    Person o = list.get(i);

    if (o.isMarkedForDeletion())
    {
        list.remove(i);
    }
    else
    {
        o.update();
    }
}
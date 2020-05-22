for (Iterator i = list.iterator(); i.hasNext();)
{
    Person o = i.next();

    o.update();

    if (list.isMarkedForDeletion())
    {
        list.remove(o);
    }
}
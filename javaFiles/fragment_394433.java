public boolean CompareTo(Name obj)
{
    if(priority < obj.priority)
    {
        return -1;
    }

    if (priority > obj.priority)
    {
        return 1;
    }

    return 0;
}
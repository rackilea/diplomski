public boolean equals(Object otherObject)
{
    if (otherObject instanceof Counter)
    {
        Counter ocounter = (Counter) otherObject;
        if (this.minimum != ocounter.minimum)
            return false;
        ...
    } else {
        return false;
    }
    return true;
}
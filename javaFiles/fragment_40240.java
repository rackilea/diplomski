public static class CustomKey {   
    ...
    @Override
    public int hashCode ()
    {
        // if you override equals, you should also override hashCode
    }

    @Override
    public boolean equals (Object other)
    {
        if (other == this)
            return true;
        if (!(other instanceof CustomKey))
            return false;
        CustomKey okey = (CustomKey) other;
        return this.topLevelId == okey.topLevelId && this.secondLevelId == okey.secondLevelId;
    }
    ...
}
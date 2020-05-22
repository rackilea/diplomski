public boolean equals(Object o)
{
    if (!(o instanceof ID))
        return false;
    ID oid = (ID) o;
    return this.code.equals(oid.code);
}
public String toString()
{
    // how do I pass different classes here?
    // by passing the 'this' reference
    return ToStringImpl.getClassString(this);
}
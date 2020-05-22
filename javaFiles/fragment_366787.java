/**
 * Implement equals based on ${cursor}. <br />
 * See {@link #compareTo(Object) compareTo}
 * @see java.lang.Object#equals(java.lang.Object)
 */
public boolean equals(final Object anObject)
{
    boolean res = false;
    if(anObject == null) { return false; }
    if(anObject == this) { return true; }
    if(anObject.getClass() == this.getClass())
    {
        res = this.compareTo(anObject) == 0;
    }
    return res;
}
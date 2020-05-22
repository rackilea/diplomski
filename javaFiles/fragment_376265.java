public int get(int position)
{
    boolean ok = rangeCheck(position);
    if(! ok)        
        throw new IndexOutOfBoundsException("Your error message");
    return storage[position];
}
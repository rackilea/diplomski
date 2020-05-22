return new Iterator<Widget>()
{
  /** Index of the next item. */
  private int index = 0;
  /** Collection size. */
  private final int size = size();

  @Override
  public boolean hasNext( )
  {return (index < size);}

  @Override
  public Widget next( )
  {
    if(!hasNext()) throw new NoSuchElementException();
    return get(index++);
  }

  @Override
  public void remove( )
  {throw new UnsupportedOperationException();}
};
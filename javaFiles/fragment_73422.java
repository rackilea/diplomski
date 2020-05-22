class PointIterator implements Iterator<Point>
{
  BufferedReader reader;
  PointIterator(BufferedReader myReader) { reader = myReader; };
  @Override
  public boolean hasNext() { return myReader.ready(); };
  @Override
  public Point next() { return makePoint(myReader.readLine()); };
  @Override
  public void remove()
  { throw new UnsupportedOperationException("Remove not supported!"); };
}
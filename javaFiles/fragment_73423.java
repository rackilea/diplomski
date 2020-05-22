class PointIterable implements Iterable<Point>
{
  BufferedReader reader;
  public PointIterable(BufferedReader myReader) { reader = myReader; };
  @Override
  public Iterator<Point> iterator() { return new PointIterator(reader); }
}
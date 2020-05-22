while (reader.ready())
{
  String line = reader.readLine();
  Point point = makePoint(line);
  handlePoint(point);
}
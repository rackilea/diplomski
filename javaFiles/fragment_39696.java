public void write(ListMultimap<Object, Object> index, OutputStream out) throws IOException
{
  Properties properties = new Properties();

  for (Object key : index.keySet())
  {
    StringBuilder values = new StringBuilder();

    for (Object value = index.get(key))
    {
      values.append(serailize(value)).append(",");
    } 

    properties.setProperty(serailize(key), values.subString(0, values.length - 1));
  }

  properties.store(out, "saving");
}
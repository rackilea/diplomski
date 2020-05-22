public ListMultimap<Object, Object> read(InputStream in) throws IOException
{
  ListMultimap<Object, Object> index = ArrayListMultimap.create();

  Properties properties = new Properties();
  properties.load(in);

  for (Object serializedKey : properties.keySet())  
  {
    String deserializedKey = deserialize(serializedKey);
    String values = properties.get(serializedKey);

    for (String value : values.split(",")) 
    {
      index.put(deserializedKey, deserialize(value)); 
    }
  }

  return index;
}
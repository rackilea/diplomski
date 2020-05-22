private static class Caching implements Implementation
  {
    private Map<String, Class> cache = new HashMap<String, Class>();

    @Override
    public Class doStuff(String clzName)
    {
      Class clz = cache.get(clzName);
      if (clz != null) return clz;
      try
      {
        clz = Class.forName(clzName);
        cache.put(clzName, clz);
      }
      catch (Exception e)
      {
      }
      return clz;
    }
  }
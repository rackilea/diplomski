private interface Implementation
  {
    Class doStuff(String clzName);
  }

  private static class Classic implements Implementation
  {
    @Override
    public Class doStuff(String clzName)
    {
      try
      {
        return Class.forName(clzName);
      }
      catch (Exception e)
      {
        return null;
      }
    }
  }
class CachedFile
{
  File realFile;
  // Initially not cached
  boolean cached = false;

  // Construct with file

  public synchronized boolean isCached()
  { return cached; }

  public synchronized void cache()
  {
    if (!cached)
    {
      // now load - safe in the knowledge that no one can get the file (or cache())
      ..
      cached = true; // done
    }
  }

  public synchronized <File> getFile()
  {
    // return the "file"
  }
}
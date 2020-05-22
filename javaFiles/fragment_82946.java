public static FSDirectory open(File path, LockFactory lockFactory) throws IOException {
  if ((Constants.WINDOWS || Constants.SUN_OS || Constants.LINUX)
        && Constants.JRE_IS_64BIT && MMapDirectory.UNMAP_SUPPORTED) {
    return new MMapDirectory(path, lockFactory);
  } else if (Constants.WINDOWS) {
    return new SimpleFSDirectory(path, lockFactory);
  } else {
    return new NIOFSDirectory(path, lockFactory);
  }
}
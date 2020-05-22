public interface ParserFactory<T> {

  /** Iterating on the returned object
   *  provides Ts parsed from the InputStream.
   *
   *  @param input must be closed by the returned object 
   *   when done iterating. 
   */
  Iterable<T> createParser(InputStream input);
}
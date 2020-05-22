public encodeIt(String input)
  {
    try {
      return input.getBytes(DEFAULT_ENCODING);
    catch(UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
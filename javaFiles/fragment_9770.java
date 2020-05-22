public int indexOf(String str, int fromIndex)
  {
    if (fromIndex < 0)
      fromIndex = 0;
    int limit = count - str.count;
    for ( ; fromIndex <= limit; fromIndex++)
      if (regionMatches(fromIndex, str, 0, str.count))
        return fromIndex;
    return -1;
  }
public String toString (int sub)
  {
    if ((sub >= start.length) || sub < 0)
      throw new IndexOutOfBoundsException ("No group " + sub);
    if (start[sub] == -1)
      return null;
    ...
  }
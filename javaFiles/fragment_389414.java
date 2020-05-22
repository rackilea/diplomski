public int countIf(E data)
{
  boolean isDataEq = Objects.equals(data, this.data);

  if(getNext() == null)
  {
    return isDataEq ? 1 : 0;
  }

  int nextCount = getNext().countIf(data);
  return isDataEq ? 1 + nextCount : nextCount;
}
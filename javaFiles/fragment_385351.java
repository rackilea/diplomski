public int compareTo(Object arg0)
{
  Frequency other = (Frequency)arg0;

  return n < other.n ? -1 : (n == other.n ? 0 : 1);
}
public boolean contains(E data)
{
  if (Objects.equals(data, this.data)) return true;
  if (next==null) return false;
  return next.contains(data);
}
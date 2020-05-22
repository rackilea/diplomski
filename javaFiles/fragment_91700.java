public boolean equals(Object object)
{
  if (object == null)
  {
    return false;
  }

  if (this == object)
  {
    return true;
  }

  if (object instanceof Point)
  {
    Point point = (Point)object;
    ... now do the comparison.
  }
  else
  {
     return false;
  }
}
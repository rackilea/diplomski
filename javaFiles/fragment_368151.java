if (f instanceof Bread)
{
  return (Bread) f;
}
if (f instanceof Meat)
{
  return (Meat) f;
}
if (f instanceof Milk)
{
  return (Milk) f;
}

throw new Exception("NotAFood!");
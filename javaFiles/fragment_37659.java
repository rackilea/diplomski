public packagename.MyClass getItemAtPosition(int position)
{
  Object item = mItems.get(position);
  if(item instanceof packagename.MyClass)
  {
    return (packagename.MyClass)item;
  }
  return null;
}
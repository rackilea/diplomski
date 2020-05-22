static Iterator func(ArrayList mylist)
{
  Iterator it=mylist.iterator();
  while(it.hasNext())
  {
     Object element = it.next();
     if(element instanceof String)
        break;
  }
  return it;

}
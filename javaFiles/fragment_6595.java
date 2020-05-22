Iterator it = map.entrySet().iterator();
while (it.hasNext())
{
   Entry item = it.next();
   map.remove(item.getKey());
}
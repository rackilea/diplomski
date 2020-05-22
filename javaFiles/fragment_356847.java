Iterator<Event> it = eventList.iterator();
while(it.hasNext())
{
  Event ev = it.next();
  if (ev.ready())
    it.remove();
}
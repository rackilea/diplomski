bool hasCircle(List l)
{
   Iterator i = l.begin(), j = l.begin();
   while (true) {
      // increment the iterators, if either is at the end, you're done, no circle
      if (i.hasNext())  i = i.next(); else return false;

      // second iterator is travelling twice as fast as first
      if (j.hasNext())  j = j.next(); else return false;
      if (j.hasNext())  j = j.next(); else return false;

      // this should be whatever test shows that the two
      // iterators are pointing at the same place
      if (i.getObject() == j.getObject()) { 
          return true;
      } 
   }
}
int s = 5;
int idx = 0;

while (idx < ArrayList2.size())
{
   if(ArrayList2.get(idx) == s)
   {
     // Remove item
     ArrayList1.remove(idx);
     ArrayList2.remove(idx);
  }
  else
  {
    ++idx;
  }
}
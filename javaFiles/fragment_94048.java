if(pos>=0)
{
    StringBuilder s1 = new StringBuilder(s);
    s1.setCharAt(pos,'0');    // <-- Here s1 is fine
    q.add(s1);
    StringBuilder s2 = new StringBuilder(s);            
    s1.setCharAt(pos,'1');    // <-- You must use s2
    q.add(s2);
}
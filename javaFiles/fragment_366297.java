synchronized(p1) 
{
    p1.cont = false;
    // p1.notify(); <- do you need this here?
}
table.removeAll();
synchronized(p2)
{
    p2.cont = true;
    p2.notify();
}
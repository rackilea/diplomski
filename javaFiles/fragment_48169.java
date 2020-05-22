ListIterator<Rectangle> i = v.listIterator();

while(i.hasNext())
{
    Rectangle r = i.next();

    if(r.contains(p))
        i.remove();
}
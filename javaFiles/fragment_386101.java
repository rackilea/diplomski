while (x != 999)
{
    System.out.println("Enter num (!=999)");
    l.insert(pos, x);
    if (pos == null)
        pos = l.getFirst();
    else
        pos = pos.getNext();
}
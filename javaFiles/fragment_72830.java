while (current != null && !current.getElement().equals(element))
{
    previous = current;
    current = current.getNext();
    found = true;
}
while (! found && current != null)
{
    if (current.getElement ().equals (element)) {
        found = true;
    }
    else {
        previous = current;
        current = current.getNext();
    }
}
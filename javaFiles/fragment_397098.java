public String toString()
{
    StringBuilder buf = new StringBuilder();
    if (front == null)
        // queue is empty
    else
        front.toStringRecursive(buf);
    return buf.toString();
}
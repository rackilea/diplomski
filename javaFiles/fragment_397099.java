public void toStringRecursive(StringBuilder buf)
{
    buf.append(this.toString());
    if (this.link != null)
        this.toStringRecursive(buf);
}
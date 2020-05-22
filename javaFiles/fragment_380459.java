@Override
public int hashCode()
{
    return getLabel().hashCode();
}

@Override
public boolean equals(Object o) {
    Vertex v = (Vertex)o;
    return v.getLabel().equals(this.getLabel());
}

@Override
public String toString()
{
    return getLabel();
}
@Override
public String toString()
{
    return "("+getSource()+","+getDestination()+")";
}

@Override
public int hashCode()
{
    return source.hashCode() ^ destination.hashCode();
}

@Override
public boolean equals(Object o) {
    Edge e = (Edge)o;
    return e.getSource().equals(this.getSource()) &&       
        e.getDestination().equals(this.getDestination());
}
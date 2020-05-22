@Override
public boolean equals(Object other)
{
    if (this == other) return true;
    if (other == null || !this.isAssignableFrom(other)) return false;
    Beacon b = (Beacon) other;
    return this.uuid.equals(b.uuid) && this.major == b.major && this.minor == b.minor;
}

@Override
public int hashCode()
{ 
    return 2047*this.major + this.minor + this.uuid.hashCode();
}
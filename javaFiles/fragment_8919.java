// Broken - violates symmetry!
@Override
public boolean equals(Object o) {
    if (o instanceof CaseInsensitiveString)
        return s.equals(((CaseInsensitiveString) o).s);
    if (o instanceof String) // One-way interoperability!
        return s.equals((String) o);
    return false;
}
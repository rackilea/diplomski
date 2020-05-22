@Override
public boolean equals(Object o) {
    if(o == null) return false;
    if(!(o instanceof Node)) return false;
    return label.equals(((Node)o).label);
}
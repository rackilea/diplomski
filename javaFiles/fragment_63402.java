@Override
public int compareTo(Glasses other) {
    if (equals(other)) {
        return 0;
    } else {
        //FIXME: when is a Glasses object smaller then an other Glasses object??
        return 0;
    }
}

@Override
public boolean equals(Object o) {
    boolean equal = false;
    if (o instanceof Glasses) {
        Glasses other = (Glasses) o;
        equal = true;
        equal &= (manufacturer == null && other.manufacturer == null) || (manufacturer != null && manufacturer.equals(other.manufacturer));
        equal &= price == other.price;
        equal &= (type == null && other.type == null) || (type != null && type.equals(other.type));
    }
    return equal;
}
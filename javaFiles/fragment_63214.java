@Override
public boolean equals(Object obj) {
    if (obj instanceof TypePair) {
        TypePair objTypePair = (TypePair) obj;
        return a            .isAssignableFrom(objTypePair.a) && b            .isAssignableFrom(objTypePair.b) ||
               objTypePair.a.isAssignableFrom(a)             && objTypePair.b.isAssignableFrom(b);
    } else {
        return false;
    }
}
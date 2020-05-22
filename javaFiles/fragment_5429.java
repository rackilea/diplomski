public int compareTo(Object o) {
     return CompareToBuilder.reflectionCompare(this, o);
}


public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
}
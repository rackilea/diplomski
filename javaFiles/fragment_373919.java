@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DtoAdapter that = (DtoAdapter) o;
    // following line of code specifically
    return Objects.equals(nameText, that.nameText) &&
            that.getXList().containsAll(xList) && xList.containsAll(that.getXList());
}
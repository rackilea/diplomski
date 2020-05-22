@Override
public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;

    final News news = (News) o;

    return this.id == news.id;

}

@Override
public int hashCode() {
    return (int) (this.id ^ this.id >>> 32);
}
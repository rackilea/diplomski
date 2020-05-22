@Override
public boolean equals(Object o) {
    if (this == o) return true; // literally the same object.

    if (o == null || getClass() != o.getClass()) return false; // Not correct type.

    BaseEntityDTO that = (BaseEntityDTO) o;
    return this.id == null ? that.id == null : this.id.equals(that.id);
}
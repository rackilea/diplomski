public boolean intersects(Entity entity) {
    if (this.getBoundingBox() == null) {
        return false;
    }
    return this.getBoundingBox().intersects(entity.getBoundingBox());
}
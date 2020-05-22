if (id == null) {
    dest.writeInt(0);
}
else {
    dest.writeInt(1);
    dest.writeInt(id);
}
public void writeToParcel(Parcel out, int flags) {
    if (id != null) {
        out.writeByte((byte) 1);
        out.writeLong(id);
    } else {
        out.writeByte((byte) 0);
    }
    out.writeString(webSafeKey);
    out.writeFloat(productivity);
    out.writeString(address);
    out.writeTypedList(areas);
}
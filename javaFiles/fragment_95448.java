public void writeToParcel(Parcel out, int flags) {
    out.writeLong(id);
    out.writeString(webSafeKey);
    out.writeFloat(productivity);
    out.writeString(address);
    out.writeTypedList(areas);
}
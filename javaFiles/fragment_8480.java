@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(Name);
    dest.writeString(ImagePath);
    dest.writeTypedList(Tags.ToArrayList());
    dest.writeString(Note);
    dest.writeByte((byte) (IsFavorite ? 1 : 0));
    if (DateAdded == null) {
        dest.writeByte((byte) 0);
    } else {
        dest.writeByte((byte) 1);
        dest.writeLong(DateAdded);
    }
}
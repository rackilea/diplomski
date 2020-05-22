@Override
public void writeToParcel(Parcel parcel, int i) {
    parcel.writeList(itemList);
    parcel.writeString(mName);
    parcel.writeString(mImageUrl);
}

protected Outfit(Parcel in) {
    in.readList(itemList, Item.class.getClassLoader());
    mName = in.readString();
    mImageUrl = in.readString();
}
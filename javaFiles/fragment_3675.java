private Site(Parcel in) {
    mData = in.readInt();

    //let's read from in Parcel an set our siteName
    siteName = in.readString();
}
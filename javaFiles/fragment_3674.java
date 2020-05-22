public void writeToParcel(Parcel out, int flags) {
    out.writeInt(mData);

    //we want to keep siteName in our parcel, so let's write it to the Parcel obj
    out.writeString(siteName);
}
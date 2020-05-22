@Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(name);
        parcel.writeInt(description);
        parcel.writeInt(category);        
        parcel.writeString(locationDistance);
        parcel.writeString(finalMapSearchUrl);
    }
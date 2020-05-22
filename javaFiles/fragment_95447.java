protected Farm(Parcel in) {
    if (in.readByte() == 0) {
        id = null;
    } else {
        id = in.readLong();
    }
    webSafeKey = in.readString();
    productivity = in.readFloat();
    address = in.readString();
    areas = new ArrayList<Area>();
    in.readTypedList(areas,Area.CREATOR);
    //areas = in.readArrayList(null);
}
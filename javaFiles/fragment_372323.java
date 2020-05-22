private PlaceObject(Parcel in) {
        name = in.readInt();
        description = in.readInt();
        category = in.readInt();
        locationDistance = in.readString();
        finalMapSearchUrl = in.readString(); 
    }
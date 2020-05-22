Location location;

public void writeToParcel(Parcel desc, int flags) {
    location.writeToParcel(desc, flags);
    /* do your other parcel stuff here */
}

public void readFromParcel(Parcel in) {
    location=Location.CREATOR.createFromParcel(in);
    /* do your other parcel stuff here */
}
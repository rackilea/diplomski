private static class ExampleCreator implements Parcelable.Creator<Account> {

    public Account createFromParcel(Parcel in) {
        return new Account(in);
    }

    public Account[] newArray(int size) {
        return new Account[size];
    }
}
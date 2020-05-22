public City(Parcel in) {
    readFromParcel(in);
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(code);
    dest.writeString(name);
    dest.writeTypedList(weathers);
}

private void readFromParcel(Parcel in) {
    code = in.readString();
    name = in.readString();
    in.readTypedList(weathers, CityWeather.CREATOR);
}

public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
    public City createFromParcel(Parcel in) {
        return new City(in);
    }

    public City[] newArray(int size) {
        return new City[size];
    }
};
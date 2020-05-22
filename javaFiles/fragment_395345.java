public enum Option implements Parcelable {

    DATA_BASE("Database"), TRIPS("Trips"), BIG_PHOTOS("BigPhotos"),
    OLD_PHOTOS("OldPhotos"), FILTERS_IMAGES("FiltersImages"),
    CATEGORIES_IMAGES("CategoriesImages"), PAGES("Pages"),
    SOUNDS("Sounds"), PUBLIC_TRANSPORT("PublicTransport"), MAPS("Maps");

    private String option;

    Option(String option){
        this.option = option;
    }

    public String getName(){
        return option;
    }

    private void setOption(String option){
        this.option = option;
    }

    public static final Parcelable.Creator<Option> CREATOR = new Parcelable.Creator<Option>() {

        public Option createFromParcel(Parcel in) {
            Option option = Option.values()[in.readInt()];
            option.setOption(in.readString());
            return option;
        }

        public Option[] newArray(int size) {
            return new Option[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(ordinal());
        out.writeString(option);
    }
}
public class MasterWithDetails implements Parcelable {
    private String value;
    private List<Detail> detailList;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(value);
        out.writeString(getName());
        out.writeTypedList(detailList); //don't forget to make Detail parcelable too!
    }

    public static final Parcelable.Creator<MasterWithDetails> CREATOR
            = new Parcelable.Creator<MasterWithDetails>() {
        public MasterWithDetails createFromParcel(Parcel in) {
            return new MasterWithDetails(in);
        }

        public MasterWithDetails[] newArray(int size) {
            return new MasterWithDetails[size];
        }
    };

    private MasterWithDetails(Parcel in) {
        value = in.readString();
        setName(in.readString());
        detailList = in.createTypedArrayList(Detail.CREATOR);
    }
}
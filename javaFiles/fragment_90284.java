public class TileList extends ArrayList<Tile> implements Parcelable {

    public TileList(){
        super();
    }

    protected TileList(Parcel in) {
        in.readTypedList(this, Tile.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this);
    }

    public static final Parcelable.Creator<TileList> CREATOR = new Parcelable.Creator<TileList>() {
        public TileList createFromParcel(Parcel in) {
            return new TileList(in);
        }

        public TileList[] newArray(int size) {
            return new TileList[size];
        }
    };
}
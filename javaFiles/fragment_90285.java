public class GameBoard implements Parcelable {
    private String _id;
    public String getId() { return _id; }
    public void setId(String id) { _id = id; }

    private List<TileList> _tiles;
    public List<TileList> getTiles() { return _tiles; }
    public void setTiles(List<TileList> tiles) { _tiles = tiles; }

    public GameBoard(Parcel in) {
        _id = in.readString();
        _tiles = new ArrayList<>();
        in.readTypedList(_tiles, TileList.CREATOR);
    }

    public GameBoard() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(_id);
        parcel.writeTypedList(_tiles);
    }

    public static final Parcelable.Creator<GameBoard> CREATOR = new Parcelable.Creator<GameBoard>() {
        public GameBoard createFromParcel(Parcel in) {
            return new GameBoard(in);
        }

        public GameBoard[] newArray(int size) {
            return new GameBoard[size];
        }
    };
}
public class MyListManager {
    private static List<Piece> mList;

    public static List<Piece> getMyList() {
        return mList;
    }

    public static void setList(List<Piece> list) {
        mList = list;
    }
}
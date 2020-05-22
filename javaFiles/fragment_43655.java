public class BooleanArrayArray implements Parcelable {
    private final boolean[][] mArray;

    public BooleanArrayArray(boolean[][] array) {
        mArray = array;
    }

    private BooleanArrayArray(Parcelable in) {
        boolean[][] array;
        final int N = in.readInt();
        array = new boolean[][N];
        for (int i=0; i<N; i++) {
            array[i] = in.createBooleanArray();
        }
        mArray = array;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        final int N = mArray.length;
        out.writeInt(N);
        for (int i=0; i<N; i++) {
            out.writeBooleanArray(mArray[i]);
        }
    }

    public static final Parcelable.Creator<BooleanArrayArray> CREATOR
            = new Parcelable.Creator<BooleanArrayArray>() {
        public BooleanArrayArraycreateFromParcel(Parcel in) {
            return new BooleanArrayArray(in);
        }

        public BooleanArrayArray[] newArray(int size) {
            return new BooleanArrayArray[size];
        }
    };
}
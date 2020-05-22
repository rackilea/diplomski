public class Vals implements Serializable, Parcelable {
    public ArrayList<RowBean> data;

    public Vals(ArrayList<RowBean> data) {
        this.data = data;
    }

    protected Vals(Parcel in) {
        if (in.readByte() == 0x01) {
            data = new ArrayList<RowBean>();
            in.readList(data, RowBean.class.getClassLoader());
        } else {
            data = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (data == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(data);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Vals> CREATOR = new Parcelable.Creator<Vals>() {
        @Override
        public Vals createFromParcel(Parcel in) {
            return new Vals(in);
        }

        @Override
        public Vals[] newArray(int size) {
            return new Vals[size];
        }
    };
}
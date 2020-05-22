public class RowBean implements Serializable, Parcelable {

    public String title;
    public boolean selected;

    public RowBean(){
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public RowBean(boolean selected, String title) {
        this.selected = selected;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    protected RowBean(Parcel in) {
        title = in.readString();
        selected = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeByte((byte) (selected ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<RowBean> CREATOR = new Parcelable.Creator<RowBean>() {
        @Override
        public RowBean createFromParcel(Parcel in) {
            return new RowBean(in);
        }

        @Override
        public RowBean[] newArray(int size) {
            return new RowBean[size];
        }
    };
}
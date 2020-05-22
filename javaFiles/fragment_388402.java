public class MyParcelable implements Parcelable {
ArrayList<String>  list;

public MyParcelable(ArrayList<String> list) {
    this.list = list;
}

protected MyParcelable(Parcel in) {
    if (in.readByte() == 0x01) {
        list = new ArrayList<String>();
        in.readList(list, String.class.getClassLoader());
    } else {
        list = null;
    }
}

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    if (list == null) {
        dest.writeByte((byte) (0x00));
    } else {
        dest.writeByte((byte) (0x01));
        dest.writeList(list);
    }
}

@SuppressWarnings("unused")
public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {
    @Override
    public MyParcelable createFromParcel(Parcel in) {
        return new MyParcelable(in);
    }

    @Override
    public MyParcelable[] newArray(int size) {
        return new MyParcelable[size];
    }
};
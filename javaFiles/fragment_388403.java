public class MyComplexParcelable implements Parcelable {

ArrayList<DummyClass> list;

public MyComplexParcelable(ArrayList<DummyClass> list) {
    this.list = list;
}

@Override
public String toString() {
    return "MyComplexParcelable{" +
            "list=" + list +
            '}';
}

protected MyComplexParcelable(Parcel in) {
    if (in.readByte() == 0x01) {
        list = new ArrayList<DummyClass>();
        in.readList(list, DummyClass.class.getClassLoader());
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
public static final Parcelable.Creator<MyComplexParcelable> CREATOR = new Parcelable.Creator<MyComplexParcelable>() {
    @Override
    public MyComplexParcelable createFromParcel(Parcel in) {
        return new MyComplexParcelable(in);
    }

    @Override
    public MyComplexParcelable[] newArray(int size) {
        return new MyComplexParcelable[size];
    }
};
public class DummyClass implements Parcelable {
int age;
String name;

public DummyClass(int age, String name) {
    this.age = age;
    this.name = name;
}

@Override
public String toString() {
    return "DummyClass{" +
            "age=" + age +
            ", name='" + name + '\'' +
            '}';
}

protected DummyClass(Parcel in) {
    age = in.readInt();
    name = in.readString();
}

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(age);
    dest.writeString(name);
}

@SuppressWarnings("unused")
public static final Parcelable.Creator<DummyClass> CREATOR = new Parcelable.Creator<DummyClass>() {
    @Override
    public DummyClass createFromParcel(Parcel in) {
        return new DummyClass(in);
    }

    @Override
    public DummyClass[] newArray(int size) {
        return new DummyClass[size];
    }
};
}
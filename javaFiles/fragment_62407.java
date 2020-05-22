public class Contact implements Parcelable{

enter code hereprivate int ID;

private String name;
private String surname;
private String dob;
private String sex;
private String address;
private Bitmap photo;

public Contact(Context context) {
    ID = -1;
    name = surname = dob = sex = address = "";
    photo = BitmapFactory.decodeResource(context.getResources(), R.drawable.default_user);
}

public Contact(int ID, String name, String surname, String dob, String sex, String address, Bitmap photo) {
    this.ID = ID;
    this.name = name;
    this.surname = surname;
    this.dob = dob;
    this.sex = sex;
    this.address = address;
    this.photo = photo;
}

public Contact(int ID, String name, String surname, Bitmap photo) {
    this.ID = ID;
    this.name = name;
    this.surname = surname;
    this.photo = photo;
}

// Here Setters & Getters

@Override
public int describeContents() {
    return 0;
}

@Override
public void writeToParcel(Parcel dest, int flags) {
    dest.writeArray(new Object[]{ID, name, surname, dob, sex, address, photo});
}

public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {

    @Override
    public Contact createFromParcel(Parcel source) {
        return new Contact(source);
    }

    @Override
    public Contact[] newArray(int size) {
        return new Contact[size];
    }
};

private Contact(Parcel parcel) {
    Object[] data = parcel.readArray(Contact.class.getClassLoader());
    ID = (Integer) data[0];
    name = (String) data[1];
    surname = (String) data[2];
    dob = (String) data[3];
    sex = (String) data[4];
    address = (String) data[5];
    photo = (Bitmap) data[6];
}
}
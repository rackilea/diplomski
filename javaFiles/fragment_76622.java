import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {

    private String name, address, city, state, phone, zip;

    @Override
    public int describeContents() {
        return 0;
    }

    /*
            THE ORDER YOU READ OBJECT FROM AND WRITE OBJECTS TO YOUR PARCEL MUST BE THE SAME
     */

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeString(phone);
        parcel.writeString(zip);
    }


    public Address(Parcel p){
        name = p.readString();
        address = p.readString();
        city = p.readString();
        state = p.readString();
        phone = p.readString();
        zip = p.readString();
    }

    // THIS IS ALSO NECESSARY
    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel parcel) {
            return new Address(parcel);
        }

        @Override
        public Address[] newArray(int i) {
            return new Address[0];
        }
    };
}
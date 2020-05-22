import android.os.Parcel;
import android.os.Parcelable;

/**
 * Custom parcelable class
 */
public class MyParcelable implements Parcelable {

    public int data;

    public MyParcelable(int data) {
        this.data = data;
    }

    private MyParcelable(Parcel source) {
        // Reading custom data
        data = source.readInt();
    }

    public static final Parcelable.Creator<MyParcelable> CREATOR
            = new Parcelable.Creator<MyParcelable>() {

        @Override
        public MyParcelable createFromParcel(Parcel source) {
            return new MyParcelable(source);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Saving custom data
        dest.writeInt(data);
    }
}
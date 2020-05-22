import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * ArrayList of the custom parcelable object
 */
public class MyParcelableList extends ArrayList<MyParcelable> implements Parcelable {

    public MyParcelableList() {
    }
    private MyParcelableList(Parcel source) {
        for (Parcelable p : source.readParcelableArray(MyParcelable.class.getClassLoader()))
            add((MyParcelable) p);
    }

    public static final Parcelable.Creator<MyParcelableList> CREATOR
            = new Parcelable.Creator<MyParcelableList>() {

        @Override
        public MyParcelableList createFromParcel(Parcel source) {
            return new MyParcelableList(source);
        }

        @Override
        public MyParcelableList[] newArray(int size) {
            return new MyParcelableList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelableArray(toArray(new MyParcelable[size()]), flags);
    }
}
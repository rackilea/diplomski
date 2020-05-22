import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    public ObjectClass obj;

    public static final String OBJECT_KEY = "Object key";

    public static Fragment2 newInstance(){
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        ObjectClass obj = new DerivedClass(); //a DerivedClass object
                               //referenced by an ObjectClass reference
        args.putParcelable(OBJECT_KEY, obj);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main2, container, false);
        if (savedInstanceState == null){
            Bundle args = getArguments();
            obj = args.getParcelable(OBJECT_KEY); //without supplying the ClassLoader
            ((TextView)view.findViewById(R.id.section_label)).setText(obj.getTitle()); 
                     //The text that is displayed is: "Child class"!
        }
        return view;
    }

    //The parent class
    public static class ObjectClass implements Parcelable {
        String title = "Parent class";

        public String getTitle(){
            return title;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }

        public static final Creator<ObjectClass> CREATOR = new Creator<ObjectClass>() {
            @Override
            public ObjectClass createFromParcel(Parcel source) {
                return new ObjectClass();
            }

            @Override
            public ObjectClass[] newArray(int size) {
                return new ObjectClass[size];
            }
        };
    }

    //The child class
    public static class DerivedClass extends ObjectClass {
        String title2 = "Child class";

        public String getTitle() {
            return title2;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }

        public static final Parcelable.Creator<DerivedClass> CREATOR = new Parcelable.Creator<DerivedClass>() {
            @Override
            public DerivedClass createFromParcel(Parcel source) {
                return new DerivedClass();
            }

            @Override
            public DerivedClass[] newArray(int size) {
                return new DerivedClass[size];
            }
        };
    }
}
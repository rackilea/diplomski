public abstract class A implements Parcelable {
    private int a;

    protected A(int a) {
        this.a = a;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(a);
    }

    protected A(Parcel in) {
        a = in.readInt();
    }
}

public class B extends A {
    private int b;

    public B(int a, int b) {
        super(a);
        this.b = b;
    }

    public static final Parcelable.Creator<B> CREATOR = new Parcelable.Creator<B>() {
        public B createFromParcel(Parcel in) {
            return new B(in);
        }

        public B[] newArray(int size) {
            return new B[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(b);
    }

    private B(Parcel in) {
        super(in);
        b = in.readInt();
    }
}
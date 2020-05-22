public class Question implements Parcelable {
    String a1;
    String a2;
    ...

    public Question(String a1, String a1) {
        this.a1 = a1;
        this.a2 = a2;
    }

    // Your existing methods go here. (There is no need for me to re-write them.) 

    // The following methods that are required for using Parcelable
    private Question(Parcel in) {
        // This order must match the order in writeToParcel()
        a1 = in.readString();
        a2 = in.readString();
        // Continue doing this for the rest of your member data
    }

    public void writeToParcel(Parcel out, int flags) {
        // Again this order must match the Question(Parcel) constructor
        out.writeString(a1);
        out.writeString(a2);
        // Again continue doing this for the rest of your member data
    }

    // Just cut and paste this for now
    public int describeContents() {
        return 0;
    }

    // Just cut and paste this for now
    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}
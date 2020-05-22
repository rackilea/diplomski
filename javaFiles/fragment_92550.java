public class Contact implements Parcelable {

   public String username = null;
   public String password = null;


   public Alumno( Parcel in ) {
      username= in.readString();
      password = in.readString();
  }

  public void writeToParcel(Parcel out, int flags ) {
      out.writeString(this.username);
      out.writeString(this.password);
  }

  public static final Parcelable.Creator<Contact> CREATOR =
        new Parcelable.Creator<Creator>() {

            public Creator createFromParcel( Parcel in ) {
                return new Contact( in );
            }

            public Contact[] newArray( int size ) {
                return new Contact[size];
            }
        };

  public int describeContents() {
      return 0;
  }
  //Your original code here (getters, setters and constructor)
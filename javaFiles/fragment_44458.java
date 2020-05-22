public class Item implements Parcelable{
   private String name;
   private String body;
   private String profileImage;

public Item(){

}

public Item(Parcel in) {
            name = in.readString();
            body = in.readString();
            profileImage = in.readString();
        }


 @Override
        public int describeContents() {
            return 0;
        }


        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(body);
            dest.writeString(profileImage);
        }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
            @Override
            public Item createFromParcel(Parcel in) {
                return new Item(in);
            }

            @Override
            public Item[] newArray(int size) {
                return new Item[size];
            }
        };


public Item(String body,String name,String profileImage){
  this.body = body;
  this.name = name;
  this.profileImage = profileImage;
}
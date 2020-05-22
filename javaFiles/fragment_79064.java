public class Response<T extends Parcelable>{
@Expose
@SerializedName("status")
private Integer status;

@Expose
@SerializedName("message")
private String message;

@Expose
@SerializedName("data")
private T data;

//Getters and Setters

@Override
public void writeToParcel(Parcel dest, int flags) {
    if (data != null) {
        dest.writeString(data.getClass().getName());
        dest.writeParcelable(data, flags);
    } else dest.writeString(null);
    dest.writeString(message);
    dest.writeInt(status);
}
}

protected Response(Parcel in) {
    String className = in.readString();
    if (className != null) {
        try {
            data = in.readParcelable(Class.forName(className).getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    message = in.readString();
    status = in.readInt();
}
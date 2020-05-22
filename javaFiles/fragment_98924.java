public class UserData implements Parcelable {
    private int UserId;
    private double EndLat, EndLong, StartLat, StartLong;
    private String Username;

    public void setUserId(int _userId) {
        this.UserId = _userId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setEndLat(double _endLat) {
        this.EndLat = _endLat;
    }

    public double getEndLat() {
        return EndLat;
    }

    public void setStartLat(double _startLat) {
        this.StartLat = _startLat;
    }

    public double getStartLat() {
        return StartLat;
    }

    public void setEndLong(double _endLong) {
        this.EndLong = _endLong;
    }

    public double getEndLong() {
        return EndLong;
    }

    public void setStartLong(double _startLong) {
        this.StartLong = _startLong;
    }

    public double getStartLong() {
        return StartLong;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getUsername() {
        return Username;
    }

    // Parcelable implementation bellow this line

    protected UserData(Parcel in) {
        UserId = in.readInt();
        EndLat = in.readDouble();
        EndLong = in.readDouble();
        StartLat = in.readDouble();
        StartLong = in.readDouble();
        Username = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(UserId);
        parcel.writeDouble(EndLat);
        parcel.writeDouble(EndLong);
        parcel.writeDouble(StartLat);
        parcel.writeDouble(StartLong);
        parcel.writeString(Username);
    }
}
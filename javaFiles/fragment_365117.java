public class Prime {

    private static final String format = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);

    private int _id;
    private int _primeno;
    private long dateTime = 0; //this is in milliseconds. Makes it easier to manage

    public Prime() { }

    public Prime(int primeNumber) {
        //create a new prime object with a prime already known. set the date while we are at it
        this._primeno = primeNumber;
        this.dateTime = System.currentTimeMillis();
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_primeno(int _primeno) {
        this._primeno = _primeno;
    }

    public int get_id() {
        return _id;
    }

    public int get_primeno() {
        return _primeno;
    }

    public long getDateTime() {
        return dateTime;
    }

    public String getDateTimeFormatted() {
        if (dateTime == 0) {
            dateTime = System.currentTimeMillis();
        }
        Date date = new Date(dateTime);
        return formatter.format(date);
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

}
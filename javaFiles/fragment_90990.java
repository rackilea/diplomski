import java.util.Date;

public class YourModelClass {
    @ServerTimestamp
    private Date date;

    YourModelClass() {}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
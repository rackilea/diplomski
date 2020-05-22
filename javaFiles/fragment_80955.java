public class Result {

    String dd;
    Date createdMillis;

    public Result(String dd, Date createdMillis) {
        super();
        this.dd = dd;
        this.createdMillis = createdMillis;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public Date getCreatedMillis() {
        return createdMillis;
    }

    public void setCreatedMillis(Date createdMillis) {
        this.createdMillis = createdMillis;
    }

}
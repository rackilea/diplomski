public class DataRow {
    private String mName;
    private int mAge;
    private String mAddress;

    public DataRow(String mName, int mAge, String mAddress) {
        this.mName = mName;
        this.mAge = mAge;
        this.mAddress = mAddress;
    }

    public String  getRow() {
        return mName + "\t" + mAge + "\t" + mAddress;
    }

    //Optional
    @Override
    public String toString() {
        return getRow();
    }

    public int getAge() {
        return mAge;
    }
}
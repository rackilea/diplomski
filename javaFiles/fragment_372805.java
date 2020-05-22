public class DataSource {

    private String mUid;

    public DataSource(String m) {
        mUid = m;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mUid == null) ? 0 : mUid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataSource other = (DataSource) obj;
        if (mUid == null) {
            if (other.mUid != null)
                return false;
        } else if (!mUid.equals(other.mUid))
            return false;
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DataSource ds1 = new DataSource("test");
        DataSource ds2 = new DataSource("test");
        System.out.println(ds1.equals(ds2));
    }

}
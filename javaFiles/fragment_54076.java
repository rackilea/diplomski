public class Pair {
    private String cr_ts_hi;
    private String cr_ts_lo;

    //constructor and getter-setter

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (cr_ts_hi != null ? !cr_ts_hi.equals(pair.cr_ts_hi) : pair.cr_ts_hi != null) return false;
        return cr_ts_lo != null ? cr_ts_lo.equals(pair.cr_ts_lo) : pair.cr_ts_lo == null;
    }

    @Override
    public int hashCode() {
        int result = cr_ts_hi != null ? cr_ts_hi.hashCode() : 0;
        result = 31 * result + (cr_ts_lo != null ? cr_ts_lo.hashCode() : 0);
        return result;
    }
}
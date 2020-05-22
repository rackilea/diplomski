public class MarketVO {

    private double floatAmt;
    private Date marketDate;
    private long marketCap;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MarketVO))
            return false;
        MarketVO other = (MarketVO) o;
        return other.floatAmt == floatAmt &&
               other.marketDate.equals(marketDate) &&
               other.marketCap == marketCap;
    }

    @Override
    public int hashCode() {
        ...
    }
}
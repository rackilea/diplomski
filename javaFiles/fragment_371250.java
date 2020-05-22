public class BnSPrice implements InterfacePrice<BnSPrice> {
    int gold = 0;
    int silver = 0;
    int copper = 0;

    @Override
    public InterfacePrice<?> addPrices(BnSPrice price1, BnSPrice price2) {
        return ...;
    }

    @Override
    public BnSPrice subtractPrices(BnSPrice price1, BnSPrice price2) {
        return ...;
    }

    @Override
    public String priceToString() {
        return ...;
    }
}
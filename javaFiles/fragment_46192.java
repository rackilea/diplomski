public class Filters implements HttpFilters {

    private final MaybeCsrfFilter csrf;

    @Inject
    public Filters(final MaybeCsrfFilter csrf) {
        this.csrf = csrf;
    }

    @Override
    public EssentialFilter[] filters() {
        return new EssentialFilter[]{csrf};
    }
}
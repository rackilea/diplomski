public class CustomNamingStrategy extends ImprovedNamingStrategy {

    private static final long serialVersionUID = -306957679456120781L;

    @Override
    public String columnName(final String columnName) {
        return CaseFormat.LOWER_CAMEL
                         .to(CaseFormat.LOWER_UNDERSCORE, columnName);
    }
}
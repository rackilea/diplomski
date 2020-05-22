public enum GenericEnum {
    STRING("HEXGEN"), 
    INTEGER(2013), 
    DATE(new Date()), 
    BOOLEAN(true), 
    BIGINTEGER(BigInteger.valueOf(Long.MAX_VALUE)), 
    LONG("1898.48");


    private String defaultString;
    private int defaultInteger;
    private Date defaultDate;
    private boolean defaultBoolean;
    private long defaultLong;
    private BigInteger defaultBigInteger;

    GenericEnum(Object value) {
        if(String.class.isAssignableFrom(value.getClass())) {
            this.defaultString = (String) value;
        } else if (Integer.class.isAssignableFrom(value.getClass())) {
            this.defaultInteger = (Integer) value;
        }
            [...]
    }
}
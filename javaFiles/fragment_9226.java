private static final Map<QName, Integer> xmlGregorianCalendarFieldRef =
            new HashMap<QName, Integer>();
    static {
            Map<QName, Integer> f = xmlGregorianCalendarFieldRef;
            f.put(DatatypeConstants.DATETIME,   0x1111111);
            f.put(DatatypeConstants.DATE,       0x1111000);
            f.put(DatatypeConstants.TIME,       0x1000111);
            f.put(DatatypeConstants.GDAY,       0x1001000);
            f.put(DatatypeConstants.GMONTH,     0x1010000);
            f.put(DatatypeConstants.GYEAR,      0x1100000);
            f.put(DatatypeConstants.GYEARMONTH, 0x1110000);
            f.put(DatatypeConstants.GMONTHDAY,  0x1011000);
    }
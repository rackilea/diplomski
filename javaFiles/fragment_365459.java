private static final String[] COLUMN_NAMES = new String[] {
        "NM", "SOURCE", "ST", "DATE_S", "DATE_E",
        "ID", "LDAP", "JE_BANK", "JE_LANG", "INFCL",
        "LIMIT", "REFCON", "CLSIGN", "COUNT", "COMM",
        "ATTR5", "ATTR20", "ATTR21", "ATTR26", "ATTR27", "ATTR28",
        "F", "I", "O", "Tel", "Product", "Kod_text", "Product_new", "Email"
    };

private static final Type[] COLUMN_TYPES = new Type[] {
    Type.CHAR, Type.CHAR, Type.CHAR, Type.CHAR, Type.CHAR,
    Type.NUMBER, Type.CHAR, Type.CHAR, Type.CHAR, Type.CHAR,
    Type.NUMBER, Type.CHAR, Type.CHAR, Type.CHAR, Type.CHAR,
    Type.CHAR, Type.CHAR, Type.NUMBER, Type.CHAR, Type.CHAR, Type.CHAR,
    Type.CHAR, Type.CHAR, Type.CHAR, Type.CHAR, Type.CHAR, Type.NUMBER, Type.CHAR, Type.CHAR
};

private static final int[] COLUMN_PRECISION = new int[] {
        6, 3, 2, 10, 10,
        10, 1, 2, 2, 18,
        10, 75, 3, 1, 1, 
        10, 1, 1, 4, 1, 17,
        254,254,254,12,254,20,254,254
    };

    for (int i = 0; i < COLUMN_NAMES.length; i++)
    {
        if (COLUMN_TYPES[i].equals(Type.CHAR))
        {
            dbfFields.add(new Field(COLUMN_NAMES[i], Type.CHARACTER, COLUMN_PRECISION[i] ));
        }
        else
        {
            Field f = new Field(COLUMN_NAMES[i], Type.NUMBER, COLUMN_PRECISION[i],0);
            dbfFields.add(f);
        }
    }
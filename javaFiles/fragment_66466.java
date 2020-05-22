enum ABEnum {

    A, B, E;

    public static ABEnum fromString(String enumStr) {
        return ABEnum.valueOf(enumStr);
    }
}

enum CDEnum {

    C, D, E;

    public static CDEnum fromString(String enumStr) {
        return CDEnum.valueOf(enumStr);
    }
}

public static Enum fromString(Enum seed, String enumStr) throws Exception {
    Class declaringClass = seed.getDeclaringClass();
    Method fromStringMethod = declaringClass.getDeclaredMethod("fromString", String.class);
    Object result;
    try {
        result = fromStringMethod.invoke(null, enumStr);
    } catch (InvocationTargetException e) {
        result = null;
    }
    return (Enum) result;
}

Map<Class, EnumSet> map = new HashMap<>();

public void test() throws Exception {
    //Enum e = fromString(ABEnum.A, "B");
    Enum[] enums = new Enum[]{ABEnum.A, CDEnum.C};
    String[] names = new String[]{"A", "B", "C", "D", "E"};
    for (Enum e : enums) {
        Class c = e.getClass();
        for (String s : names) {
            EnumSet set = map.get(c);
            if (set == null) {
                map.put(c, set = EnumSet.noneOf(c));
            }
            Enum found = fromString(e, s);
            if (found != null) {
                set.add(found);
            }
        }
    }
    System.out.println(map);
}
public class Person {
    private static int  _ID_COUNTER = 0;
    private int         _ID;
    private String      _Name;
    private String      _FamilyName;

    public Person(String name, String familyName) {
        _ID  = ++ID_COUNTER;
        _Name = name;
        _FamilyName = familyName;
    }

    @Override
    public String toString() {
        return _Name;
    }

    public int get_ID() {
        return _ID;
    }

    public String get_Name() {
        return _Name;
    }

    public String get_FamilyName() {
        return _FamilyName;
    }

}
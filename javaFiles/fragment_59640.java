// Use an interface to inform the super class what the enums can do.
public interface Named {
    public String getName();
}

// Super class of all Tables.
public static class Table<E extends Enum<E> & Named> {
    private final Class<E> itsClass;
    private final String sheetName;
    private final String fileName;

    public Table(Class<E> itsClass) {
        this.itsClass = itsClass;
        // Walk the enum to get filename and sheet name.
        String sheetName = null;
        String fileName = null;
        for ( E e: itsClass.getEnumConstants() ){
            if ( e.name().equals("FILENAME")) {
                fileName = e.getName();
            }
            if ( e.name().equals("THEAD")) {
                sheetName = e.getName();
            }
        }
        this.sheetName = sheetName;
        this.fileName = fileName;
    }

    // Use the interface and the enum details to do your stuff.
    public E getByName (String name) {
        for ( E e: itsClass.getEnumConstants() ){
            if ( e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
}

// Extend Table and tell it about your enum using the super constructor.
public static class TableContent extends Table<TableContent.Nit> {

    public TableContent() {
        super(TableContent.Nit.class);
    }

    public enum Nit implements Named{
        FILENAME("Nit-workorder-list"),
        THEAD("NIT WORKORDER"),
        TENDERSPECNO("TENDER SPECFICATION NO."),
        FEE("TENDER FEE"),
        SDAMOUNT("SD AMOUNT"),
        TYPE("NIT TYPE"),
        PRE_BID("PRE BIDDING DATE"),
        OPEN_DATE("OPENING DATE"),
        STATUS("CONTRACTOR STATUS");

        private final String name;

        Nit(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
public class SomeClass extends IStreamSorterTest<SomeType> {

    private static final String FOLDER_NAME = ...;
    private static final String FILE_EXT = ...;
    private static final String SCHEMA_FILE_EXT = ...;

    public SomeClass() {
        super(FOLDER_NAME, FILE_EXT, SCHEMA_FILE_EXT);
    }
}
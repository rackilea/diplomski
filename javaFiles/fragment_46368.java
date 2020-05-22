public abstract class IStreamSorterTest<T> {

    protected final String pathPrefix;
    protected final String userFile;
    protected final String sortedUserFile;
    protected final String usersXMLSchema;

    protected IStreamSorterTest(String folderName, String fileExt, String schemaFileExt) {
        pathPrefix = "src/test/resources/" + folderName;
        userFile = "users" + fileExt;
        sortedUserFile = "sorted_users" + fileExt;
        usersXMLSchema = "users_schema" + schemaFileExt;
    }

}
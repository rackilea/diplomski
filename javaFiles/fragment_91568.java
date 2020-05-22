public abstract class FileManagementExecution<T extends AbstractRepository> implements Execution<T> {
    private FileManagementExecution() {}

    public static final FileManagementExecution<ConcreteReprisitory1> UPLOAD_PERSON_FILE =
            new FileManagementExecution<ConcreteReprisitory1>() {
                @Override
                public void execute(ConcreteReprisitory1 repository, String fileName) {
                    //TODO
                }
            };
    public static final FileManagementExecution<ConcreteReprisitory2> DELETE_PERSON_FILE =
            new FileManagementExecution<ConcreteReprisitory2>() {
                @Override
                public void execute(ConcreteReprisitory2 repository, String fileName) {
                    //TODO
                }
            };
    // other constants
}
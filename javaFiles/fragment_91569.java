public interface FileManagementExecution<T extends AbstractRepository> extends Execution<T> {
    FileManagementExecution<ConcreteReprisitory1> UPLOAD_PERSON_FILE = 
            ((repository, fileName) -> TODO());
    FileManagementExecution<ConcreteReprisitory2> DELETE_PERSON_FILE = 
            ((repository, fileName) -> TODO());
    // other constants
}
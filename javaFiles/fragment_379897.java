public class ProduktException extends Exception {

    boolean notDeleted;
    boolean notCreated;

    public ProduktException(String msg){
        super(msg);
    }

    public boolean isNotDeleted() {
        return(notDeleted);
    }

    public boolean isNotCreated() {
        return(notCreated);
    }

    public static void throwProduktNotCreatedException() throws ProduktException {
        ProduktException e = new ProduktException("Cannot be created!");
        e.notCreated = true;
        throw e;
    }

    public static void throwProduktNotDeletedException () throws ProduktException {
        ProduktException e = new ProduktException("Cannot be deleted!");
        e.notDeleted = true;
        throw e;
    }
}
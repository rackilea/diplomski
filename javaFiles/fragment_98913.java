public class ExampleDAO() extends DAOValidation{
    public void insert(Object obj) {
         if(validationOnInsert(obj)){...}
    }
    public boolean validateOnInsert(Object obj) {
         //your validation here
    }
    public boolean validateOnDelete(Object obj) {
         //your validation here
    }
}
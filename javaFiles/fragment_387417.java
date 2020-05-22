public class ResponseObject {
    public final boolean success;
    public final String errorMessage;
    public final List<MyItem> items;

    @JsonCreator
    public ResponseObject(List<MyItem> items) {
       this.success = true;
       this.errorMessage = null;
       this.items = items;
    }

    @JsonCreator
    public ResponseObject(ErrorResponse error){
        this.success = error.isSuccess();
        this.errorMessage = error.getErrorMessage();
        this.items = null;
    }

}
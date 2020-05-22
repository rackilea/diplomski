class ResponseModel {

    // ERROR
    private final Boolean success;
    private final Error error;

    // SUCCESS
    private final int item_count;
    // more success values... 

    ResponseModel(Boolean success, Error error, int item_count) {
        this.success = success;
        this.error = error;
        this.item_count = item_count;
    }

    public class Error {
        private final int code;
        private final String message;

        private Error(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }

    public Boolean getSuccess() {
        return success;
    }

    public Error getError() {
        return error;
    }

    public int getItem_count() {
        return item_count;
    }
}
public class BusinessException extends Exception {

    private BusinessError error;

    public BusinessError(String reason) {
        this.error = new BusinessError(reason, new Date());
    }

    // getters and setters..
}
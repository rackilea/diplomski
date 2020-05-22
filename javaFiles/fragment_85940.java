public enum ValidationStatus {
  SUCCESS, ERROR1, ERROR2
}

public class ValidationResult {

    private ValidationStatus status;
    private String errorMessage;

    public ValidationResult(ValidationStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return status == ValidationStatus.SUCCESS;
    }

    public ValidationStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
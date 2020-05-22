//============required==================
public DocumentValidationException(String message, ErrorsBean errorsBean, Throwable cause) {
    super(message, cause);
    this.errorsBean = errorsBean;
}

public ErrorsBean getFaultInfo() {
    return errorsBean;
}

public DocumentValidationException(String message, ErrorsBean errorsBean) {
    super(message);
    this.errorsBean = errorsBean;
}
//======================================
throw new Exception("Error") {
    // Here is what makes the exception user-defined.
    // You do not need to override anything, but if you want, you can:
    public String getMessage() {
        return "Here is your user-defined exception!";
    }
};
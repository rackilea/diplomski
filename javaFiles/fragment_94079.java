try {
    this.manageException(() => {
        // Do something here
    });
}
catch (MyCustomException mce) {
    int code = mce.getCode();
}
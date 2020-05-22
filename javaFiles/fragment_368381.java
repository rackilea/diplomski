ResponseModel responseModel = response.body();

if (responseModel.getError() == null) {
    // success
    doSomethingWithSuccess(responseModel.getItem_count())
} else {
    // error
    doSomethingWithError(responseModel.getError())
}
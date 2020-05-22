private boolean serviceReturnedSuccess(Response response) {
    try {
        return response.getMetadata().getReturnCode() != 0;
    }
    catch (NullPointerException e) {
        return false;
    }
}
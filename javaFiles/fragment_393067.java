public String getResult() {
    String retValue;
    if (!processed) {
        retValue = String.format("Still busy after %d requests", counter++);
    } else {
        retValue = result;
    }
    return retValue;
}
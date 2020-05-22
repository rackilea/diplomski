class XsListGetter {
    private String sourceHtml;
    private boolean requestSucceeded = false;
    private int httpStatusCode = 0;

    public void fetchHtml(String url) {
        try {
            sourceHtml = //get the HTML as a string from the url
            httpStatusCode = //get the status code of the request, will be 200 if successful
            requestSucceeded = true //if we get here, we were successful
        } catch (IoException e) {
            requestSucceeded = false //otherwise, we didn't succeed
        }
    }

    public boolean requestSucceeded { //allow to check if the request succeeded
        return requestSucceeded && httpStatusCode == 200;
    }

    public List<MyItem> parseHtmlToList() {
        return parseHtmlStringToList(sourceHtml); //parse your Html to a list of items here
    }
}
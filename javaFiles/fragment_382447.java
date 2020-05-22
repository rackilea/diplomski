public List<String> processSheet(Sheet sheet) {
    /*... same code as previous example ...*/

    // the following removes all "" or null values
    while(headers.remove(null) || headers.remove("")){}

    return headers;
}
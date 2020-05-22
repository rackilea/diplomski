protected void processLine(String aLine){
    StringTokenizer st = new StringTokenizer(aLine, "=");
    if(st.countTokens() == 2) {
        log("Name is : " + quote(st.nextToken().trim()) + ", and Value is : " + quote(st.nextToken().trim()));
    } else {
        log("Empty or invalid line. Unable to process.");
    }
}
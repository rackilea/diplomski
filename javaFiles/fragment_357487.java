public String getDecodedContents() {
    if( decodedContents == null ) {
        byte[] decoded = Base64.decodeBase64(getEncodedContents().getBytes());
        String newString = new String(decoded);
        decodedContents = newString;
        decodedContents = decodedContents.replace('\r','\t');
    }
    return decodedContents;
}
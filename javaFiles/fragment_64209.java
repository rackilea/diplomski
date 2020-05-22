String filen = vars.get("currentFile");
def result = filen =~ /.*\/\/(.*)/; //matches end of the string after the last //
if (result.hasGroup()) {
    filen = result[0][1]
    log.info("file:"+filen)
}
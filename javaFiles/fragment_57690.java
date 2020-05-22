String logdata = new Scanner(new File("/path/to/server.log")).useDelimiter("\\Z").next();
final String needle = "Report Process started";
int occurrences = 0;
int index = 0;
while (index < logdata.length() && (index = logdata.indexOf(needle, index)) >= 0) {
    occurrences++;
    index += needle.length();
}
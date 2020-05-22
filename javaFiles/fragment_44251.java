public static final String ISSUE_UPLOAD_FILE_PATTERN = "(?<=(^|,))(([^\",]+)|\"([^\"]*)\")(?=($|,))";
public static void main(String[] args) {
    String line = "DOB,1234567890,11,07/05/12,\"first,last\",100,\"is,a,good,boy\"";
    Matcher matcher = Pattern.compile(ISSUE_UPLOAD_FILE_PATTERN).matcher(line);
    while (matcher.find()) {
        if (matcher.group(3) != null) {
            System.out.println(matcher.group(3));
        } else {
            System.out.println(matcher.group(4));
        }
    }
}
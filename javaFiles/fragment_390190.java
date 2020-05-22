String pattern = ".*\n((?:\\S+\\s+){2})(.*)";
String str = "Filesystem     1MB-blocks   Used Available Use% Mounted on\n" +
              "/dev/sda6         72342MB 5013MB   63655MB   8% /common";
Pattern r = Pattern.compile(pattern,  Pattern.DOTALL);
Matcher m = r.matcher(str);
if (m.matches()) {
    System.out.println(m.group(1));
}
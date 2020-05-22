final String regex = "(PM\\s*\\d+)/PM\\s*\\d+.*";    
final Pattern pattern = Pattern.compile(regex);
final Matcher matcher = pattern.matcher(str);

if (matcher.matches()) {
    flag = true;
    str = matcher.group(1);
}
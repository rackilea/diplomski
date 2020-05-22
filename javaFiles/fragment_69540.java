Pattern gregorianPattern = Pattern.compile("^java.util.GregorianCalendar\\[time=(\\d+).*"); 

Matcher matcher = gregorianPattern.matcher(param);
if(matcher.matches()) {
    return Long.parseLong(matcher.group(1));
}
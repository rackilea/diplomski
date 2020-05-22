public String processText(String stringToShow, String appname) {
    Matcher m=Pattern.compile("\\[%(\\w+)%\\]").matcher(stringToShow);
    if(!m.find()) return stringToShow;
    StringBuffer sb=new StringBuffer();
    do {
        String replacement;
        switch(m.group(1).toLowerCase(Locale.ROOT)) {
            case "applicationname":
                replacement=appname;
                break;
            case "datetime":
                replacement = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                break;
            case "date":
                replacement = LocalDate.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;
            case "time":
                replacement = LocalTime.now().format(
                    DateTimeFormatter.ofPattern("HH:mm:ss"));
                break;
            default:
                replacement = "Invalid";
        }
        m.appendReplacement(sb, replacement);
    } while(m.find());
    return m.appendTail(sb).toString();
}
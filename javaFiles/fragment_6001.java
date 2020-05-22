public static void main(String[] args) {

    String str = "\"EndDate\":\"\\/Date(1487615921387-0300)\\/\",\"StartDate\":\"\\/Date(1487608721387-0300)\\/\"";
    //Get Long from your String between Date( and )
    String start = "Date(", end = ")";
    String regexString = Pattern.quote(start) + "(.*?)" + Pattern.quote(end);
    Pattern pattern = Pattern.compile(regexString);
    Matcher matcher = pattern.matcher(str);
    List<String> res = new ArrayList<>();
    while (matcher.find()) {
        //now we get results like this 1487608721387-0300
        res.add(matcher.group(1));
    }

    //You can change the format like you want
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Date date;
    String[] split;
    for (String s : res) {
        split = s.split("-");
        ///we should to split the String to get the first part 1487608721387
        //then we get Date from this String
        date = new Date(new Long(split[0]));
        //Set time zone to your format i'm not sure if it is correct you can avoid it
        //format.setTimeZone(TimeZone.getTimeZone(split[1]));
        //Show your date
        System.out.println(format.format(date));
    }
}
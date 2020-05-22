String[] patterns = {"yyyy-MM-dd HH", "yyyy-MM-dd HH:mm", ...};//<<---your formats

for (String pattern : patterns) {
    try {
        new SimpleDateFormat(pattern).parse("your date");
        System.out.println("Correct date");
        break;//if your date is correct break your look
    } catch (ParseException e) {
        System.out.println("Incorrect date");
    }
}
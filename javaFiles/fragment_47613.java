public static void main(String[] args) throws ParseException {
    String from = "5:10:00";
    String to = "10:10:00";
    String n = "08:10:00";
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    Date date_from = formatter.parse(from);
    Date date_to = formatter.parse(to);
    Date dateNow = formatter.parse(n);
    if (date_from.before(dateNow) && date_to.after(dateNow)) {
        System.out.println("Yes time between");
    }
    }
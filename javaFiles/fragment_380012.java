private static void print() {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();
    String s = dateFormat.format(date).toString();
    print(s);
}
public static void main(String[] args) {
    Date date = new Date();
    String formatted_date = generateCronExpression
                             (Integer.toString(date.getSeconds()),
                              Integer.toString(date.getMinutes()),
                              Integer.toString(date.getHours()),
                              Integer.toString(date.getDate()),
                              Integer.toString(date.getMonth() + 1), // see Note #2
                              "?",
                              Integer.toString(date.getYear() + 1900));
}
public static void main(String[] args) {
    long timeInMillis = System.currentTimeMillis();
    Calendar cal1 = Calendar.getInstance();
    cal1.setTimeInMillis(timeInMillis);
    cal1.add(Calendar.HOUR, 8);
    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss a");
    String dateforrow = dateFormat.format(cal1.getTime());
    System.out.println(dateforrow );
}
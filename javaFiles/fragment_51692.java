public static void main(String[] args) {
    Date d1 = Calendar.getInstance().getTime();
    d1 = new Date(ThreadLocalRandom.current().nextLong(d1.getTime()));

    System.out.println("Today's date is: " + d1.toString());
    System.out.println("Milliseconds: " + d1.getTime());
}
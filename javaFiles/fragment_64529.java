try {
    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
    System.out.println("Original Date: " + d);
    System.out.println("Formatted Date: " + df.parse(df.format(d)));
} catch (Exception e) {
    e.printStackTrace();
}
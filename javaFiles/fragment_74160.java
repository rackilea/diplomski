java.util.Date d = jDateChooser3.getDate();
if (d == null) {
    System.out.println("No date specified!");
} else {
    java.sql.Date sqldate = new java.sql.Date(d.getTime());
    // Do something with sqldate
}
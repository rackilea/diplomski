try {           
   Date date1;
   SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
   date1 = format.parse("05/18/05");
   System.out.println(format.format(date1));
}
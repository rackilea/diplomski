SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Calendar calendar = new GregorianCalendar();
calendar.set(2018, 0, 1, 0, 0, 0);
for (int i = 0; i < 5; i++) {
     System.out.println(sdf.format(calendar.getTime()));
     Date date = calendar.getTime();
     System.out.println(sdf.format(date));
     System.out.println(date.getTime());
}
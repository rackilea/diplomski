Calendar cal=Calendar.getInstance();
    cal.set(Calendar.YEAR,2012);
    cal.set(Calendar.MONTH,12-1);
    cal.set(Calendar.DATE,30);
    Date date=cal.getTime();
    System.out.println(date);
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
    // Java SimpleDateFormat use `yyyy` (lowercase) not `YYYY`(uppercase)
    String YYYY_MM=format.format(date);
    System.out.println(YYYY_MM); //out put 2012-12
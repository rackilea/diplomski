String s1 = "2013-01-15 8:00:03";
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd h:mm:ss");
    try {
        Date dt=sdf.parse(s1);//converting to date
         SimpleDateFormat sdf1=new SimpleDateFormat("dd-MMM-yyyy h:mm:ss");
         String s2=sdf1.format(dt);//formating to new format string
         System.out.println(s2);
    } catch (ParseException ex) {

    }
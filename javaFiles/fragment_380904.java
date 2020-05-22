Date d2 = new SimpleDateFormat("yyyy-M-dd").parse((String)"2012-10-24");

        Calendar calendar= Calendar.getInstance();
        Calendar csd= Calendar.getInstance();
        calendar.setTime(d2);
        calendar.add(calendar.DAY_OF_MONTH, -5);        
        System.out.println(new Date(calendar.getTimeInMillis()));
        csd.add(csd.DAY_OF_MONTH, -5);      
        System.out.println(new Date(csd.getTimeInMillis()));    


csd.add(calendar.get(Calendar.DAY_OF_MONTH), -5);//wrong is giving an invalid argument
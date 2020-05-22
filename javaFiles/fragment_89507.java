Date d1 = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
        Date d2 = new Date();
        f.format(d2);
        System.out.println(d1);//e.g. Thu Aug 08 12:09:24 IST 2013
        System.out.println(d2);//e.g. Thu Aug 08 12:09:26 IST 2013
        System.out.println(d1.equals(d2));//false
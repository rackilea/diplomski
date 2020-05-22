SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
        String String1 = "2014-08-12 09:00:00";
        String String2 = "2014-08 09:00:00";

        Date date1 = formatter.parse(String1);
        formatter.applyPattern("yyyy-MM HH:mm:dd");
        Date date2 = formatter.parse(String2);

        if(date1.equals(date2)){
            System.out.println(" yes ");
        }else{
            System.out.println(" no ");
        }
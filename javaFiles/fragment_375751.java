try {
        String str_date = "01/11";
        DateFormat formatter;
        Date date;
        formatter = new SimpleDateFormat("MM/yyyy");
        date = (Date) formatter.parse(str_date);
        formatter = new SimpleDateFormat("MM/dd/yyyy");
        System.out.println("Today is " + formatter.format(date));
    } catch (ParseException e) {
        System.out.println("Exception :" + e);
    }
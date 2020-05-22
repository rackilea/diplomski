public static void main(String[] args)
    {
        String date1Str = "Wed, 24 Feb 2016 09:02:12";
        String date2Str = "Tue, 23 Feb 2016 09:01:59";

        SimpleDateFormat format = new SimpleDateFormat("E, DD MMM YYYY HH:mm:ss"); //Create formatter based on your required formats

        try
        {
            Date date1 = format.parse(date1Str); //convert string to date object
            Date date2 = format.parse(date2Str);
            System.out.println(date1.after(date2)); //compare the date
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
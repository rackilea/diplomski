SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
SimpleDateFormat output = new SimpleDateFormat("hh:mm aa");

        Date d = null;
        Date d1 = null;
        try 
        {
            d = input.parse("2018-02-05 17:08:52.503");
            d1 = input.parse("2018-02-05 17:06:55.372");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formatted = output.format(d);
        String formatted1 = output.format(d1);

        Log.i("DATE", "" + formatted);
        Log.i("DATE1", "" + formatted1);
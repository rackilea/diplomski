public static String GetYearSlot(int option,String inputDate)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy",java.util.Locale.getDefault());
        Date myDate = null;
        try
        {
            myDate = sdf.parse(inputDate);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);

        calendar.add(Calendar.YEAR, option);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date YearFirstDay = calendar.getTime();
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        Date YearLastDay = calendar.getTime();

        return sdf.format(YearFirstDay)+"-"+sdf.format(YearLastDay);
    }
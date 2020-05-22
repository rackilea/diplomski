public static String convertDateFormat(String oldFormat, String newFormat, String inputDate)
    {
        DateFormat theDateFormat = new SimpleDateFormat(oldFormat);
        Date date = null;

        try
        {
            date = theDateFormat.parse(inputDate);
        }
        catch (ParseException parseException)
        {
            // Date is invalid. Do what you want.
        }
        catch (Exception exception)
        {
            // Generic catch. Do what you want.
        }

        theDateFormat = new SimpleDateFormat(newFormat);
        return theDateFormat.format(date).toString();
    }
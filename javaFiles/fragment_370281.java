String getMonthForInt(String monthNum) 
{
        String month = "";
        DateFormatSymbols dfs = new DateFormatSymbols();
        int m = Integer.parseInt(monthNum) - 1;
        String[] months = dfs.getMonths();
        if (m >= 0 && m <= 11 ) {
            month = months[m];
        }
        return month;
}
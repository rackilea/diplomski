public void setBeginTijd()
{
        String dateStart = "22.08.2014 22:00";
        String dateEnd = "25.08.2014 01:00";

        SimpleDateFormat fullFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        Date d1 = null;
        Date d2 = null;

        try
        {
            d1 = fullFormat.parse(dateStart);
            d2 = fullFormat.parse(dateEnd);

            long diff = d2.getTime() - d1.getTime();
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.println("Delta minutes: " + diffMinutes);
            System.out.println("Delta hours: " + diffHours);
            System.out.println("Delta days: " + diffDays);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
}
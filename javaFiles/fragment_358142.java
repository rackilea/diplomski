public class Appointment{
    /**
    * three letter month
    */
    private final String month;

    /**
    * one to two digit day e.g. 1 or 12,
    */
    private final int day;

    /**
    * two digit military time hour e.g. 01, 11, 17
    */
    private final int hour;

    /**
    * lazily instantiated appointment Date
    */
    private Date date;

    //..

    public class Appointment(String month, int day, int hour /*other parameters*/){
        this.month = month;
        this.day = day;
        this.hour = hour;

        calculateDate();
    }

    private void caculateDate(){
        String dateString = String.format("%d %s 2018 %d",day,month,hour);
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy HH");

        try{
            this.date = dateFormat.parse(dateString);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Date getDate(){
        return date;
    }
}
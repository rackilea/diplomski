public class Values {
    public int freqDay = 0;
    public int freqWeek = 0;

    public int totalDay;
    public int getTotalDay(){
       totalDay = freqDay*2;
       return totalDay;
    }

    public int totalWeek;
    public int getTotalWeek(){
       totalWeek = freqWeek*2;
       return totalWeek;
    }
}
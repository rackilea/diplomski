import java.time.*;
import java.util.*;
public class Timer
{
public  ArrayList<Timer> timers;
private LocalDateTime start;
long duration;
private LocalDateTime end;

public Timer(){}
public Timer(LocalDateTime start, long duration)
{
    this.start = start;
    this.duration = duration;
    this.end = start.plusMinutes(duration);

}
public LocalDateTime getStart()
{
    return start;

}
public Timer getNextTimer(Timer timer)
{
    start = end;
    Timer i = new Timer(start,45);
    return i;
}

public void shortenDuration(long duration)
{
    long d = duration;
    this.end = start.plusMinutes(d); 
}
public LocalDateTime getEndTime()
{
     return end;
}
public void startAt(LocalDateTime end)
{
    start=end;
}
public String getFormattedTime(Timer timer)
{
    int hour = start.getHour();
    int minutes = start.getMinute();
    return(String.valueOf(hour)+":"+String.valueOf(minutes));
}
}
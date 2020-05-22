package Demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
public class Test1 {
    public static void main(String arg[]) {
        LocalDateTime ct = LocalDateTime.now();
        LocalDateTime custemTime = ct.plusMinutes(5);
        System.out.println(ct);
        System.out.println(custemTime)  ;
        System.out.println(isInSameSlots(ct,custemTime));

    }   
    static boolean   isInSameSlots(LocalDateTime ldt1, LocalDateTime ltd2) {
        Long timeDiff = ChronoUnit.MINUTES.between(ldt1, ltd2);
        if(timeDiff > 30 || timeDiff < 0) 
           return false;
        return (ldt1.getMinute() <= 30 && ltd2.getMinute() <= 30) || (ldt1.getMinute() > 30 && ltd2.getMinute() > 30 ) ? true : false; 

    }

}
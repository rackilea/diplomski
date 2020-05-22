import java.util.Scanner;
public class HWfive{ 
        public static void findFinalDayTemperature(int days, int temp){
           int half = days / 2; 
           int newtemp = temp + 2;
          for (int current_day = 1; current_day <= half; current_day++){        
                  newtemp = newtemp - 2;                                                
             }
          for (int current_day = half + 1; current_day <= days; current_day++){ 
                  newtemp++;                                                        
             }
              System.out.println("Temperature on final day would be " + newtemp);
      }
         public static void main(String[] args){
         Scanner keyboard = new Scanner(System.in);           
           int days;                                         
           int temp;
          System.out.print("number of days: ");   
             days = keyboard.nextInt();                                      
          System.out.print("temperature of first day: ");              
             temp = keyboard.nextInt(); 
             findFinalDayTemperature(days,temp);
       }
class TemperaturePattern{ 
    int num_of_days = 0;
    int temp_first_day = 0;
     public void TemperaturePattern(int temp, int days){
         days = num_of_days;
         temp = temp_first_day; 
        }    
     public int num_of_days(int days){
       return days;
      }    
     public int temp_first_day(int temp){
        return temp;
      }
      }
}
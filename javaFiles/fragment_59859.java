public class PhaseIII {


     public static void main(String[] args) {
         array_info data= new array_info();
         int selection;

         selection = data.menu();

         //call start_program & start_program1  
         //DO WHILE LOOP    
         while(selection!=4)
         {
             if (selection == 1)
             {
                 //put call to Modify_flight
                 data.flight_report();
             }
             else if (selection == 2)
             {
                 //put call to Modify_reservation
                 //data.modify_reservation();
             }
             else if (selection == 3)
             {
                 //put call to Report
                 data.report();
             }
             selection =data.menu();
         }//END WHILE LOOP
         //call exit_program   
         data.exit_program();
         System.exit(0);
     }//end main method
}
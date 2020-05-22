import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class array_info
{
    int count=-1;
    int rcount=-1;
    String [] flight = new String [100];
    int    [] flight_number = new int [100];
    String [] origin = new String [100];
    String [] destination = new String [100];
    String [] date = new String [100];
    String [] time = new String [100];

    int    [] fl_number = new int [100];
    int    [] reservation_code = new int [100];
    String [] last_name = new String [100];
    String [] first_name = new String [100];
    String [] seat_type = new String [100];
    double [] seat_cost = new double [100];
    {

        count=start_program();
        rcount=start_program1();{
        }
    }

    int menu()
    {
        String mnumber ="";
        int number;
        String output = "ACME AIRLINE SYSTEM" + " \n " + " \n " +
                "1. ADD/MODIFY FLIGHT INFORMATION" + " \n " +
                "2. ADD/MODIFY RESERVATION INFORMATION (Don't Work Yet)" + " \n " +
                "3. REPORT SECTION" + " \n " +
                "4. EXIT AIRLINE SYSTEM" + " \n" + " \n " +
                "Please make your selection  >";
        mnumber = JOptionPane.showInputDialog(null, output, " ",
                JOptionPane.QUESTION_MESSAGE);

        if(mnumber == null || mnumber.length() == 0 ){
            number = 4;
        }
        else{
            try{
                number=Integer.parseInt(mnumber);
            }
            catch(Exception e){
                number = 4;
            }
        }

        return number;
    }//method menu

    int modify_flight()
    {
        String mnumber2;
        int number2;
        String output = "Modify Flight Information Menu" + " \n " + " \n " +
                "1. ADD FLIGHT" + " \n " +
                "2. DELETE FLIGHT" + " \n " +
                "3. MODIFY FLIGHT" + " \n " +
                "4. EXIT THIS MENU" + " \n" + " \n " +
                "Please make your selection  >";
        mnumber2 = JOptionPane.showInputDialog(null, output, " ",
                JOptionPane.QUESTION_MESSAGE);
        if(mnumber2 == null || mnumber2.length() == 0 ){
            number2 = 4;
        }
        else{
            try{
                number2=Integer.parseInt(mnumber2);
            }
            catch(Exception e){
                number2 = 4;
            }
        }
        return number2;    
    }//method modify_flight

    int reportmenu()
    {
        String mnumber3;
        int number3;
        String output = "ACME AIRLINES" + " \n " +
                " 1. All Flight Info" + " \n " +
                " 2. All Reservation Info (Don't Work Yet)" + " \n " +
                " 3. Value of Reservations of a specific type (Don't Work Yet)" + " \n " +
                " 4. All Reservations of a specific flight (Don't Work Yet)" + " \n" + 
                " 5. All Flights from a specific city (Don't Work Yet)" + " \n" +
                " 6. Specific Reservation Information (Don't Work Yet)" + " \n" +
                " 7. Summary of all flights (Don't Work Yet)" + " \n" +
                " 8. All Flights to a specific city (Don't Work Yet)" + " \n" +
                " 9. Exit Report Menu" + " \n" +
                " Please make your selection  >";
        mnumber3 = JOptionPane.showInputDialog(null, output, " ",
                JOptionPane.QUESTION_MESSAGE);
        if(mnumber3 == null || mnumber3.length() == 0 ){
            number3 = 9;
        }
        else{
            try{
                number3=Integer.parseInt(mnumber3);
            }
            catch(Exception e){
                number3 = 9;
            }
        }
        return number3; 
    }//method report_menu

    int start_program()
    {
        String newLine;
        try
        {
            //define a file valuable for Buffered read
            BufferedReader Flights_file = new BufferedReader(new FileReader("flightsx.dat"));
            //read lines in file until there are no more lines in the file to read
            while ((newLine = Flights_file.readLine()) != null)
            {
                //there is a "#" between each data item in each line
                StringTokenizer delimiter = new StringTokenizer(newLine,"#");
                count=count+1;
                flight[count] =delimiter.nextToken();
                flight_number[count] = Integer.parseInt(delimiter.nextToken());
                origin[count] =delimiter.nextToken();
                destination[count] =delimiter.nextToken();
                date[count] =delimiter.nextToken();
                time[count] =delimiter.nextToken();
            }//while loop
            Flights_file.close();
        }//end try
        catch (IOException error)
        {
            //there was an error on the file writing
            System.out.println("Error on file read " + error);
        }//error on read
        return count;
    }//end start_program

    int start_program1()
    {
        String newLine;
        try
        {
            //define a file valuable for Buffered read
            BufferedReader Reservation_file = new BufferedReader(new FileReader("reservationx.dat"));
            //read lines in file until there are no more lines in the file to read
            while ((newLine = Reservation_file.readLine()) != null)
            {
                //there is a "#" between each data item in each line
                StringTokenizer delimiter = new StringTokenizer(newLine,"#");
                rcount=rcount+1;
                reservation_code[rcount] = Integer.parseInt(delimiter.nextToken());
                fl_number[rcount] = Integer.parseInt(delimiter.nextToken());
                last_name[rcount] =delimiter.nextToken();
                first_name[rcount] =delimiter.nextToken();
                seat_type[rcount] =delimiter.nextToken();
                seat_cost[rcount] = Double.parseDouble(delimiter.nextToken());
            }//while loop
            Reservation_file.close();
        }//end try
        catch (IOException error)
        {
            //there was an error on the file writing
            System.out.println("Error on file read " + error);
        }//error on read
        return rcount;
    }//end start_program1   

    void flight_report()
    {
        // DECLARED VARIABLES]
        int selection2;
        selection2 =modify_flight();
        //DO WHILE LOOP    
        while(selection2!=4)
        {
            if (selection2 == 1)
            {
                //put call to add flight
                add_flight();
            }
            else if (selection2 == 2)
            {
                //put call to delete flight
                delete_flight();
            }
            else if (selection2 == 3)
            {
                //put call to mod flight
                mod_flight();
            }
            selection2 =modify_flight();
        }//END WHILE LOOP
    }//method report

    int add_flight()
    {
        //add new flight information
        String svalue,Output;

        if(count<99){
            count=count+1;
            Output = "Enter the Flight Company";                    //string
            svalue =JOptionPane.showInputDialog(null,Output,
                    "",JOptionPane.QUESTION_MESSAGE);
            flight[count] = svalue;

            Output = "Enter the Flight Number";                     //4 digit integer
            svalue =JOptionPane.showInputDialog(null,Output,
                    "",JOptionPane.QUESTION_MESSAGE);
            flight_number[count] = Integer.parseInt(svalue);

            Output = "Enter the Flight City Origin";                //string
            svalue =JOptionPane.showInputDialog(null,Output,
                    "",JOptionPane.QUESTION_MESSAGE);
            origin[count] = svalue;

            Output = "Enter the Flight City Destination";           //string
            svalue =JOptionPane.showInputDialog(null,Output,
                    "",JOptionPane.QUESTION_MESSAGE);
            destination[count] = svalue;

            Output = "Enter the Flight Date";                       //string
            svalue =JOptionPane.showInputDialog(null,Output,
                    "",JOptionPane.QUESTION_MESSAGE);
            date[count] = svalue;

            Output = "Enter the Flight Time";                       //string
            svalue =JOptionPane.showInputDialog(null,Output,
                    "",JOptionPane.QUESTION_MESSAGE);
            time[count] = svalue;
        }


        return count;
    }//method modify_flight

    void delete_flight()
    {
        String output, svalue;
        int position=0;
        int numFlight = 0;
        output="Enter the Flight Number to delete ";
        svalue=JOptionPane.showInputDialog(null,output,
                "Input Data",JOptionPane.QUESTION_MESSAGE);

        if(svalue == null || svalue.length() == 0 ){
            numFlight = -1;
        }
        else{
            try{
                numFlight=Integer.parseInt(svalue);
            }
            catch(Exception e){
                numFlight = -1;
            }
        }

        if(count>-1 && numFlight > -1){
            if(count <99 ){
                for(int i=0;i<=count;i++)
                {
                    if(flight_number[i] == numFlight)
                        position =i;
                }
                for(int i=position;i<=count;i++)
                {
                    flight_number[i] = flight_number[i+1];
                    flight[i] = flight[i+1];
                    origin[i] = origin[i+1];
                    destination[i] = destination[i+1];
                    date[i] = date[i+1];
                    time[i] = time[i+1];
                }
            }
            else{
                flight_number[99] = 0;
                flight[99] = "";
                origin[99] = "";
                destination[99] = "";
                date[99] = "";
                time[99] = "";
            }
            count-=1;
        }

    }

    void mod_flight()
    {
        String output,svalue, value;
        int position=-1;
        int modselect;
        int numFlight = 0;
        output="Enter the Flight Number to modify ";
        svalue=JOptionPane.showInputDialog(null,output,
                "Input Data",JOptionPane.QUESTION_MESSAGE);

        if(svalue == null || svalue.length() == 0 ){
            numFlight = -1;
        }
        else{
            try{
                numFlight=Integer.parseInt(svalue);
            }
            catch(Exception e){
                numFlight = -1;
            }
        }

        if(count >-1 && numFlight > -1){
            for(int i=0;i<=count;++i)
            {
                if(flight_number[i] == numFlight)
                    position =i;
            }

            if(position>-1){

                output="";
                output=output+"1. Modify Flight Company "+"\n";
                output=output+"2. Modify City Origin "+"\n";
                output=output+"3. Modify City Destination "+"\n";
                output=output+"4. Modify Flight Date "+"\n";
                output=output+"5. Modify Flight Time "+"\n";
                output=output+" Please make your selection ";

                value=JOptionPane.showInputDialog(null,output,
                        "Input Data",JOptionPane.QUESTION_MESSAGE);
                modselect=Integer.parseInt(value);

                if(modselect ==1)
                {
                    output = "Enter the Flight Company";
                    svalue =JOptionPane.showInputDialog(null,output,
                            "",JOptionPane.QUESTION_MESSAGE);
                    flight[position] = svalue;

                }
                else if(modselect==2)
                {
                    output = "Enter the Flight City Origin";
                    svalue =JOptionPane.showInputDialog(null,output,
                            "",JOptionPane.QUESTION_MESSAGE);
                    origin[position] = svalue;
                }
                else if(modselect==3)
                {
                    output = "Enter the Flight City Destination";
                    svalue =JOptionPane.showInputDialog(null,output,
                            "",JOptionPane.QUESTION_MESSAGE);

                    destination[position] = svalue;
                }
                else if(modselect==4)
                {
                    output = "Enter the Flight Date";
                    svalue =JOptionPane.showInputDialog(null,output,
                            "",JOptionPane.QUESTION_MESSAGE);

                    date[position] = svalue;
                }
                else if(modselect==5)
                {
                    output = "Enter the Flight Time";
                    svalue =JOptionPane.showInputDialog(null,output,
                            "",JOptionPane.QUESTION_MESSAGE);

                    time[position] = svalue;
                }

            }
        }
    } 

    /*int modify_reservation()
    {
        //add new flight information
        String svalue,Output;
        rcount=rcount+1;
        Output = "Enter the Reservation Code";                      //4 digit integer
        svalue =JOptionPane.showInputDialog(null,Output,
                "",JOptionPane.QUESTION_MESSAGE);
        reservation_code[rcount] = Integer.parseInt(svalue);
        Output = "Enter the Flight Number";                         //4 digit integer
        svalue =JOptionPane.showInputDialog(null,Output,
                "",JOptionPane.QUESTION_MESSAGE);
        fl_number[rcount] = Integer.parseInt(svalue);
        Output = "Enter the Last Name";                             //string
        svalue =JOptionPane.showInputDialog(null,Output,
                "",JOptionPane.QUESTION_MESSAGE);
        Output = "Enter the First Name";                            //string
        svalue =JOptionPane.showInputDialog(null,Output,
                "",JOptionPane.QUESTION_MESSAGE);
        Output = "Enter the Type of Seat";                          //string
        svalue =JOptionPane.showInputDialog(null,Output,
                "",JOptionPane.QUESTION_MESSAGE);
        Output = "Enter the Cost of seat";                          //double
        svalue =JOptionPane.showInputDialog(null,Output,
                "",JOptionPane.QUESTION_MESSAGE);
        seat_cost[rcount] = Double.parseDouble(svalue);
        return rcount;
    }*///method modify_reservation

    void report()
    {
        // DECLARED VARIABLES]
        int selection3;
        selection3 =reportmenu(); 
        //DO WHILE LOOP    
        while(selection3!=9)
        {
            if (selection3 == 1)
            {
                //put call to All Flight Info
                display_flight();
            }
            else if (selection3 == 2)
            {
                //put call to All Reservation Info
                //display_reservation();
            }
            else if (selection3 == 3)
            {
                //put call to Value of Reservations of a specific type
                //seat_value();
            }
            else if (selection3 == 4)
            {
                //put call to All Reservations on a specific flight
                //print_flight();
            }
            else if (selection3 == 5)
            {
                //put call to All flights from a specific city
                //city_origin();
            }
            else if (selection3 == 6)
            {
                //put call to Specific reservation information 
                //reserve_info();
            }
            else if (selection3 == 7)
            {
                //put call to Summary of all flights 
                all_flights();
            }
            else if (selection3 == 8)
            {
                //put call to All flights to a specific city 
                //city_destination();
            }
            selection3 =reportmenu();
        }//END WHILE LOOP
    }//method report

    void display_flight()
    {
        int i;
        System.out.println("All flight Information:");
        for(i=0;i<=count;++i)
        {
            System.out.println(flight[i]+" "+flight_number[i]+" "+origin[i]+" "+destination[i]+" "+date[i]+" "+time[i]);
        }
    }// method display_flight

    /*void display_reservation()
    {
        int i;
        System.out.println("All Reservations Information:");
        for(i=0;i<=rcount;++i)
        {
            System.out.println(reservation_code[i]+" "+fl_number[i]+" "+last_name[i]+" "+first_name[i]+" "+seat_type[i]+" "+seat_cost[i]);
        }
    }*/// method display_reservation

    /*void seat_value()
    {
        int i;
        double total=0;
        String search_seat = "";
        String output = "Enter the Seat Type you are searching for";
        search_seat = JOptionPane.showInputDialog(null,
                output, " ",
                JOptionPane.QUESTION_MESSAGE);
        for (i = 0; i <=rcount; ++i) {
            //CHECK IF coach, first, or business
            if(seat_type[i].equals(search_seat))
            {
                total+=seat_cost[i];
                System.out.println(reservation_code[i]+" "+fl_number[i]+" "+last_name[i]+" "+first_name[i]+" "+seat_type[i]+" "+seat_cost[i]);
            }
        }
        System.out.println("The total for " +search_seat+ " = " +total);
    }*/// method seat_value

    /*void print_flight()
    {
        int i;
        int total=0;

        String search_flight = "";
        String output = "Enter the Flight Number you are searching for";
        search_flight = JOptionPane.showInputDialog(null,
                output, " ",
                JOptionPane.QUESTION_MESSAGE);

        for (i = 0; i <=rcount; ++i) {
            //CHECK flight number
            int flight_number = Integer.parseInt(search_flight);
            if(fl_number[i] == flight_number)

            {
                total+=fl_number[i];
                System.out.println(reservation_code[i]+" "+fl_number[i]+" "+last_name[i]+" "+first_name[i]+" "+seat_type[i]+" "+seat_cost[i]);
            }
        }
    }*///method print_flight

    /*void city_origin()
    {
        int i, j;
        int match_count= 0;
        String search_city = "";
        String output = "Enter the City from a particular flight you are searching for";
        search_city = JOptionPane.showInputDialog(null,
                output, " ",
                JOptionPane.QUESTION_MESSAGE);

        System.out.println(" All flights from "+search_city);
        for (i = 0; i <=count; ++i) {
            if(origin[i].equals(search_city))
            {
                System.out.println(flight[i]+" "+flight_number[i]+" "+origin[i]+" "+destination[i]+" "+date[i]+" "+time[i]);
                match_count=0;
                for (j = 0; j <=rcount; ++j) 
                {
                    if(flight_number[i] == fl_number[j])
                        match_count=match_count+1;
                }//j loop
                System.out.println("The total reservations for " +flight_number[i]+ " = " +match_count);
            }//if match
        }
    }*///method city_origin

    /*void reserve_info()
    {
        int i, j;
        int match_count=0;
        String search_reservation = "";
        String output = "Enter the Reservation Code";
        search_reservation = JOptionPane.showInputDialog(null,
                output, " ",
                JOptionPane.QUESTION_MESSAGE);

        for (i = 0; i <=rcount; ++i) {
            //CHECK reservation code
            int r_code= Integer.parseInt(search_reservation);
            if(reservation_code[i] == r_code) 
            {
                System.out.println(reservation_code[i]+" "+fl_number[i]+" "+last_name[i]+" "+first_name[i]+" "+seat_type[i]+" "+seat_cost[i]);
                match_count=0;
                for (j = 0; j <=count; ++j)
                {
                    if(fl_number[i] == flight_number[j]);                      //print flight info from that fl_number
                    match_count=match_count+1;
                }//j loop
                System.out.println(flight[j]+" "+flight_number[j]+" "+origin[j]+" "+destination[j]+" "+date[j]+" "+time[j]);
            }//if match
        } 
    }*///method reserve_info

    void all_flights ()
    {
        int i;
        System.out.println("All flight Information:");
        for(i=0;i<=count;++i)
        {
            System.out.println(flight[i]+" "+flight_number[i]+" "+origin[i]+" "+destination[i]+" "+date[i]+" "+time[i]);
        }// NEED TO CATEGORIZE ALL RESERVATIONS (FL_NUMBER) BENEATH EACH FLIGHT (FLIGHT_NUMBER)
    }//method all_flights

    /*void city_destination ()
    {
        int i, j;
        int match_count= 0;
        String search_destination= "";
        String output = "Enter the City to a particular flight you are searching for";
        search_destination= JOptionPane.showInputDialog(null,
                output, " ",
                JOptionPane.QUESTION_MESSAGE);
        System.out.println(" All flights from "+search_destination);
        for (i = 0; i <=count; ++i) 
        {
            if(destination[i].equals(search_destination))
            {
                System.out.println(flight[i]+" "+flight_number[i]+" "+origin[i]+" "+destination[i]+" "+date[i]+" "+time[i]);
                match_count=0;
                for (j = 0; j <=rcount; ++j) 
                {
                    if(flight_number[i] == fl_number[j])
                        match_count=match_count+1;
                }//j loop
                System.out.println("The total reservations for " +flight_number[i]+ " = " +match_count);
            }//if match
        }
    }//method city_destination*/

    void exit_program()
    {
        String string ;
        FileWriter fw;
        try {
            //System.out.println(count);
            fw = new FileWriter(new File("flightsx.dat"),false);
            BufferedWriter bw = new BufferedWriter(fw);
            //String string = "";
            for(int i =0;i<=count;i++){
                string =flight[i]+"#"+flight_number[i]+"#"+origin[i]+"#"+destination[i]+"#"+date[i]+"#"+time[i]+"\n";
                //System.out.println(string);
                bw.write(string);
            }
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Executing exit_program");
    }//method exit_program 


}//END OF CLASS
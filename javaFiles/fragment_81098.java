//Call the function directly without putting a print statement around it
weekDay(maxTemp,tempList)); 
//...
// Return days
public static void weekDay(int i, int[] array) //Change the return type to void
{
    int[] displayWeekDay = searchTemp(array, i);
    for(i = 0; i < displayWeekDay.length; i++){
        switch(displayWeekDay[i])
        {
            //Print each one
            case 0: System.out.println("Sunday"); break;
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            case 4: System.out.println("Thursday"); break;
            case 5: System.out.println("Friday"); break;
            case 6: System.out.println("Saturday"); break;
        }
    }
}
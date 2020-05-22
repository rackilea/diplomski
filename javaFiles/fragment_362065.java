public double getWeeklyPay() {
// Call the getWeeklyHours method of the Emp's timecard to get the total hours worked
// and then multiply the returned value by the emp's hourly rate and return the value.

double empWeeklyPay;
double sumOtHours = 0;
double sumRegHours = 0;
int i = 0;


while(i < getTimeCard().NUMDAYS) {
// grabbing the overtime and regHours and storing them

    double otHours = 0;
    double regHours = 0;
    otHours += getTimeCard().getHoursByDay(i);
    regHours += getTimeCard().getHoursByDay(i) - otHours;
    sumOtHours += otHours;
    sumRegHours += regHours;
    i++;
}    

empWeeklyPay = (sumRegHours * getHourlyRate()) + (sumOtHours * getHourlyRate() * 1.5);

if(Integer.toString(getEmployeeId()).charAt(0) == '0' || Integer.toString(getEmployeeId()).charAt(0) == '2'
|| Integer.toString(getEmployeeId()).charAt(0) == '9') {
// Java reads in 1010 so need to convert to a string to do a count on the value.

    double tmpBasePay = (sumRegHours * getHourlyRate()) + (sumOtHours * getHourlyRate() * 1.5);  
    tmpBasePay += (tmpBasePay * .10); 
    empWeeklyPay = tmpBasePay;
}

else if(Integer.toString(getEmployeeId()).charAt(0) == '3') {
  double tmpBasePay = (sumRegHours * getHourlyRate()) + (sumOtHours * getHourlyRate() * 1.5);
    tmpBasePay -= (tmpBasePay * .10);
    empWeeklyPay = tmpBasePay;
}

else if(Integer.toString(getEmployeeId()).charAt(0) == '8') { 
    double tmpBasePay = (sumRegHours * getHourlyRate()) + (sumOtHours * getHourlyRate() * 1.5);  
    tmpBasePay += (tmpBasePay * .20);
    empWeeklyPay = tmpBasePay;
}

if(sumRegHours > 34) {
    empWeeklyPay -= (empWeeklyPay * .06 );
    return empWeeklyPay;
}

else
    return empWeeklyPay;
}
public int getDayOfYear() { //This is library method
    return getChronology().dayOfYear().get(getMillis());
}

if(!getDayOfYear() <=365 ||!getDayOfYear() <=366) { //Considering leap year
System.out.println("It is not the end of year !!!");
}
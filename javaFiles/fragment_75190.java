Iterator<Date> iterator = datesAndInts.keySet().iterator();  
while (iterator.hasNext()) {  
    Date key = iterator.next();
    System.out.println("comparing " + testDate + "with " + key + " result is " + testDate.equals(key)); 
    // this call to equals() returns true now.
}
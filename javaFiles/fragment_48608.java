SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
Date maxDate = sdf.parse("01/01/2099");  // This is the limit

if(someDate.after(maxDate)){            
    System.out.println("Invalid date");            
}
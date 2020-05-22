System.out.println("Before try block");
try(Close1 c1 = new Close1(); Close2 c2 = new Close2(c1)){
    System.out.println("In try block");
}
catch(Exception ex){
    System.out.println("Exception: "+ex);
}
finally{
    System.out.println("In finally block");
}
System.out.println("After try block");
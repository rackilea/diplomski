boolean valid = true;

if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("")) {     
    Toast.makeText(getApplicationContext(),"Enter all Details first", Toast.LENGTH_SHORT).show();    
    valid = false;
}   
if(!s5.matches("[A-Za-z0-9]+")) {    
    e5.setError("Username cannot contain special characters");  
    valid = false;
} 
if(s5.length()<6) {
    e5.setError("Username must be a minimum of 6 characters.");
    valid = false;
} 
if(!(s3.contains("@")&& s3.contains("."))) {
    e3.setError("Enter a valid Email Id");    
    valid = false;
}   
if(!s6.equals(s7)) {
    e7.setError("Passwords dont match");
    valid = false;
} 
if(s2.length()!=10) {     
    e2.setError("Please enter a valid 10 digit number");
    valid = false;
} 
if (valid) {
    Validate v2=new Validate();
    v2.store_values(s1,s2,s3,s4,s5,s6,s8);
    v2.execute();
}
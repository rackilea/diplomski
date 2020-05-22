String theAge = age.trim().getText();
int agee = 0;
// Regular Expression used to ensure a Integer 
// Numerical String value was supplied.
if (theAge.matches("\\d+")) {
    agee = Integer.parseInt(theAge);
}
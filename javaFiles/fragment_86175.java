/**
 * Method to extract the user's age from the entered Date of Birth.
 * 
 * @param DoB String The user's date of birth.
 * 
 * @return ageS String The user's age in years based on the supplied DoB.
 */
private String getAge(int year, int month, int day){
    Calendar dob = Calendar.getInstance();
    Calendar today = Calendar.getInstance();

    dob.set(year, month, day); 

    int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

    if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
        age--; 
    }

    Integer ageInt = new Integer(age);
    String ageS = ageInt.toString();

    return ageS;  
}
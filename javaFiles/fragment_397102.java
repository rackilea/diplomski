String errorString = "";
boolean validate = true;
if(!ageString.isEmpty() && !heightString.isEmpty() && !weightString.isEmpty()) {
    if(age < 9 || age > 70) {
        errorMessage += "Invalid age!";
        validate = false;
    }
    if(height < 100 || age > 250) {
        errorMessage += "Invalid height!";
        validate = false;
    }
    if(weight < 30 || weight > 300) {
        errorMessage += "Invalid weight!";
        validate = false;
    }
}
else {
    errorString = "No empty fields allowed!";
    validate = false;
}
if(validate) {
    //Do whatever you want
}
else return errorString;
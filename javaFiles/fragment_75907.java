int genderValue = 0;
if (id == R.id.radioButtonMale){
    genderValue = 0;
}else{
    genderValue = 1;
}

//then you can save genderValue to database

//get value from database
int genderValue = ....; //get from database
if (genderValue == 0){
    radioGroup.check(R.id.radioButtonMale);
}else{
    radioGroup.check(R.id.radioButtonFemale);
}
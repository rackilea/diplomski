if (service.childRecordExists()){
   response.setMessage("Failed.  A child record exists");  //a useful error message for the user, as you know *exactly* why failure happened
} else {
    service.someMethod();
    response.setMessage("Success");
}
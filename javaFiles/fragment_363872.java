public void addPatient(View view){

    int id; // Added this line
    String fname = PatientFirstName.getText().toString();
    String lname = PatientLastName.getText().toString();
    String dept = departments.getSelectedItem().toString();

    patientDbHelper = new PatientDbHelper(this);
    sqLiteDatabase = patientDbHelper.getWritableDatabase();
    patientDbHelper.addInformations(id,fname,lname,dept,sqLiteDatabase); //added 'id' in arguments..
    Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
    patientDbHelper.close();

}
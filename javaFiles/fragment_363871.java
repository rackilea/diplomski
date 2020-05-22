public void addInformations(int id, String fname, String lname, String department, SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        if ( id != 0 ) contentValues.put(PatientInfo.NewPatientInfo.PATIENT_ID, id);
        contentValues.put(PatientInfo.NewPatientInfo.PATIENT_FNAME,fname);
        contentValues.put(PatientInfo.NewPatientInfo.PATIENT_LNAME,lname);
        contentValues.put(PatientInfo.NewPatientInfo.PATIENT_DEPARTMENT,department);


        db.insert(PatientInfo.NewPatientInfo.TABLE_NAME, null,contentValues);

        Log.e("DATABASE OPERATIONS","One in row inserted...");
    }
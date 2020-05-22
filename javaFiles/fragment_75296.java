private class dbHelper {
  Database mDB; // set this up however you are doing it already

  private void addStudent(StudentRecord newRecord){
    mDB.beginTransaction();
    try {
      ContentValues StudentRecordToAdd = new ContentValues();
      StudentRecordToAdd.put(Students.STUDENT_ID, newRecord.getStudentName());
      StudentRecordToAdd.put(Student.STUDENT_TYPE, newRecord.getStudentType());
      StudentRecordToAdd.put(Student.STUDENT_LOCATION, newRecord.getStudentLocation());
      StudentRecordToAdd.put(Student.STUDENT_MOTHER, newRecord.getStudentMother());
      mDB.insert(Student.STUDENT_TABLE_NAME,Student.STUDENT_ANIMALID, StudentRecordToAdd);
      mDB.setTransactionSuccessful();
      Toast.makeText(this,"Recorded Added ",0).show();
    } finally {
      mDB.endTransaction();
    }
  }
}
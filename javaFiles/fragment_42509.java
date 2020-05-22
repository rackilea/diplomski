private Employee getEmployeeByProj(String name){
 try {


            databaseHelper = new DatabaseHelper(this);
            db=databaseHelper.getReadableDatabase();


             final String where = EMP_TABLE + "=\"" + name + "\"";

            Cursor cursor = db.query("employee_details",new String[] {"staff_emp_name","department","designation"},where,null,null,null,null);

            if(cursor!=null && cursor.moveToFirst())
            {

                        final String name = cursor.getString(cursor
                            .getColumnIndex(EMP_COL_NAME));
                        final String dept = cursor.getString(....
                        final String designation cursor.getString(.....

                      //do the rest of the code here

                  return new Employee(name,dept,designation);
                }
        }

        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    }
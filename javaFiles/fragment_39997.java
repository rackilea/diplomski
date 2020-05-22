// Create a list of objects of ModelProfileClass
List<ModelProfileClass> profileList= new ArrayList<ModelProfileClass>();

Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
if (cursor.moveToFirst()) {

//  For each iteration, making the object null
ModelProfileClass  profileObject= null;
do {

    // Constructor is invoked in the model class and so, the object values are set.
    profileObject= new ModelProfileClass(
                    cursor.getString(0) ,
                    cursor.getString(1)  

            );

                    // Adding current object to the object array list
            profileList.add(profileObject);
    } while (cursor.moveToNext()); // Do this till the last record.
    cursor.close();
@Override
public void bindView(View v, Context con, Cursor cursor) {
      ViewHolder holder = (ViewHolder) v.getTag() //retrieve the holder with the row views
      // set the current image status
      int status = cursor.getInt(cursor.getColumnIndex(FAV_CODE)); // get the status( I don't know how you store the favorite status, I assumed is an int in the FAV_CODE column, 1 for favorite, 0 for unpicked yet)
      if (status == 1) {
          // the user set as favorite
          holder.image.setImageResource(R.drawable.favorite); // set the favorite drawable
      } else {
         // this isn't a favorite so put the default image
         holder.image.setImageResource(R.drawable.normal); // set the normal drawable 
      } 
      //get the row id from the cursor that we will pass in the onClick method as a tag for the image
      long id = cursor.getLong(cursor.getColumnIndex(DIAG_ID));
      holder.image.setTag(new Long(id)); 
      // set the image listener
      holder.image.setOnClickListener(new View.OnClickListener(){

         @Override
         public void onClick(View v){
             long rowID = (Long) v.getTag();
             //there is no need to find the view, and you don't modify the imageview image from here    
             // query the database to find the row with the _id equal to rowID
             // find out what value we have in the column with the image status (either 1 or 0 meaning favorite or not favorite)
             // update the row with the new status (if you have 1 in the database then update the status with 0 , if you have 0 in the database then update the value with 1)
             //call notifyDatasetChanged on the adapter to let the adapter know about the update, I don't know if this call will work with SimpleCursorAdapter, you may have to set a new adapter on the ListView with a new cursor.
         }
      });

}
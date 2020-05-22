public void song(int pos){
             try
             {
             if(mp==null)
             {
             mp = new MediaPlayer();
             }
             mp.reset();
             Cursor filename = mDbHelper.fetchProject3FileName(pos);
             expfilename =filename.getString(filename.getColumnIndexOrThrow(GinfyDbAdapter.CATEGORY_COLUMN_EXPFILENAME)); 
             mp.setDataSource(ExperiencesActivity.this, Uri.parse(expfilename));
             Toast.makeText(getApplicationContext(),expfilename, 1000).show();
             mp.prepare();
             mp.start();     
             }catch(Exception e)
             {
                 e.printStackTrace();
             }               
         }
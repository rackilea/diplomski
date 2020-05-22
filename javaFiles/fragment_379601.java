protected void onPostExecute(ArrayList<String>... result) {

    if(YourClassName.directoriesTeacher.size()>0)
     {
       YourClassName.directoriesTeacher.clear();
      }

      YourClassName.directoriesTeacher.addAll(result);

     }
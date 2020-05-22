File dir = getExternalFilesDir("appName/courses/course_name/chapter_name/pdf ");

if ( ! dir.exists())
   if (! dir.mkdirs())
      {
      Toast( "Could not make directory " + dir.getAbsolutePath());
      return;
      }
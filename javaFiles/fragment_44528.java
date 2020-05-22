String path = "..."; // Whatever the path may be
File file = new File(path);

if (file.isDirectory()) {
   // The path exists and it is a directory
   if (file.canWrite() {
       // The directory is writable
   } else {
       // The directory is not writable
   }
} else {
   // The path is not a directory, or it does not even exist
}
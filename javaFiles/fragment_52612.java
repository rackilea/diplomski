long lastProcessed = -1;
File file = new File(fileName);
while(true) {
   long lastModified = file.lastModified();
   if (lastProcessed != lastModified) {
      lastProcessed = lastModified;
      process(file);
   }
   else {
     //some delay or sleep, else you're thrashing the thread and file
   }
}
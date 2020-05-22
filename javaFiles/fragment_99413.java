while ((bytesRead = inputStream.read(buffer)) != -1) {
      outputStream.write(buffer, 0, bytesRead);
      if(paused) {
         // How do you want to handle pausing? See below for options.
      }
      if(stopped) {
         // delete the file and close the streams. 
      }
}
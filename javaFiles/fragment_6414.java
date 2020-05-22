try{
    ...
 } catch(FileNotFoundException e) {
    logger.log("No such file or permission denied {}",file);
 } catch(IOException e) {
    logger.log("I/O error while reading file {}",file);
 }
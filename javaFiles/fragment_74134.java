public void doit() throws IOException {
  try{
  }catch(IOException e){
    // try to recover
    ...

    // can't recover
    throw e;
  }
}

public void doit() {
  try{
  }catch(IOException e){
    // try to recover
    ...

    // can't recover
    throw new RuntimeException(e);
  }
}



public void doit() {
  try{
  }catch(IOException e){
    // try to recover
    ...

    // OH NO!!!!
    System.exit(Constant.UNRECOVERABLE_IO_ERROR);
  }
}
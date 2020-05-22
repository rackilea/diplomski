RConnection c;

void setup() {
  try {
    c = new RConnection();
    c.eval("library('png');library('glmnet')");
  } 
  catch ( REngineException e ) {
    e.printStackTrace();
  }
}

void draw() {
  try {
    //you can now use your c variable here
  }
  catch ( REXPMismatchException rme ) {
    rme.printStackTrace();
  }
  catch ( REngineException e ) {
    e.printStackTrace();
  }
}
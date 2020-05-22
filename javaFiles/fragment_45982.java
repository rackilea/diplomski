public abstract class TestParent {

   private void methodThatUseFile(){
    // invoke child implementation
    // in this way parent can use project created in child class
    File project= this.getProjectFile();
     // TODO

   }

  abstract File getProjectFile();

}
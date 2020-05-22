//VERY simplified...
class ReadProfileStrategy implements MyStrategy {
  void execute(MyInputContext input, MyOutputContext output) {
    //do the stuff that was in the if-else block in the "readProfile" part
  }
}

//... at the branching part:
MyInputContext input; //build this here
MyOutputContext output; //build this here

switch (purpose) {
    case "readProfile":
         // no need to always instantiate this, it should be stateless...
         new ReadProfileStrategy().execute();
         break;
    //... left out for sake of brevity
}
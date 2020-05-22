public class SomeClass {
    public SomeClass(Log.Builder builder){
       Log.Builder localBuilder = new Log.Builder(builder); //copy constructor being used.
       localBuilder.tag("SomeClass"); //only applies to the local builder
       log = localBuilder.build();
    } //builder is as it was before the call, no side effect
}
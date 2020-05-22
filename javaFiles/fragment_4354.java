public class SomeClass {
    public SomeClass(Log.Builder builder){
       builder.tag("SomeClass"); //bad, we caused a side effect
                                 //someone class forgets to set the tag
                                 //later, then they get this tag
       log = builder.build();
    }
}
@JsonIdentityInfo(
       generator = ObjectIdGenerators.PropertyGenerator.class, 
       property = "id")
class B {
    //some fields

    @ManyToOne
    @IgnorePrivateBInAToAvoidStackOverflow
    private Set<A> collectionOfAs;
}
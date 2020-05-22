@JsonIdentityInfo(
       generator = ObjectIdGenerators.PropertyGenerator.class, 
       property = "id")
class A {
    //some fields
    //Integer id;


    @OneToMany private B b; //if only A is requested, this should NOT be ignored    
}
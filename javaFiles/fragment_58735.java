@JsonTypeInfo(  
    use = JsonTypeInfo.Id.NAME,  
    include = JsonTypeInfo.As.PROPERTY,  
    property = "_class")  
@JsonSubTypes({  
    @Type(value = Cat.class, name = "com.example.Cat"),  
    @Type(value = Dog.class, name = "com.example.Dog") })  
abstract class AnimalMixIn  
{  

}
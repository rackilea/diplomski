@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
@JsonSubTypes.Type(value = Dog.class, name = "Dog"),
@JsonSubTypes.Type(value = Cat.class, name = "Cat") }
)
interface AnimalMixIn {}
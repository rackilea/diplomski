@JsonDeserialize(using = MyDeserializer.class)
class GenericEntity<T> {
    List<T> myList;

    GenericEntity(List<T> myList) {
        this.myList = myList;
    }
}
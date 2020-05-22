public interface MongoSample {

default void one(){
    System.out.println("mango one");
    two("mango two");
}
default void two(String s){}

}
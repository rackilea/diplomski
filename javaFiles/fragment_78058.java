public interface Builder<T> {
  public T build(String nameString);
}
public static void main(String[] args){
  Builder<Dog> builder =  new Builder<Dog>()
  {

     @Override
     public Dog build(String nameString)
     {
        return new Dog(nameString);
     }

  };
 Dog dog = builder.build("Rocky");
 System.out.print(dog.name);
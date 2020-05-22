public interface Dog {
}

public class Labrador implements Dog
{
}

public abstract class DogKennel<T extends Dog> {

    public void insertDog(T dog) {
        //does something and the dog is not stored
    }

}

public final class RetrieverDogKennel extends DogKennel<Retriever> {
}

public final class GeneralDogKennel extends DogKennel<Dog> {
}
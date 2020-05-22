@Client
public interface HelloWorldClient extends HelloOperations {

   @Override
   Single<String> helloBody(String name, String text);
}
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

public class Main {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new MyModule());
    Cursor<User> instance = 
        injector.getInstance(Key.get(new TypeLiteral<Cursor<User>>() {}));
    System.err.println(instance.repository);
  }
}
import java.lang.reflect.Type;
import java.util.function.Supplier;

import com.google.common.reflect.TypeToken;

public abstract class MySupplier<T> implements Supplier<T> {

  private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) { };
  private final Type type = typeToken.getType();

  public Type getType() {
    return type;
  }
}

public class Test {

  public static void main(String[] args) {

    Supplier<String> supplier = new MySupplier<String>() {
      @Override
      public String get() {
        return new String();
      }
    };
    System.out.println(((MySupplier) supplier).getType());
  }
}
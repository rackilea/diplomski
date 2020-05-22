import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GenericClass extends GenericSuper<String, Integer> {
  public GenericClass() {
    ParameterizedType gen = (ParameterizedType) getClass().getGenericSuperclass();
    TypeVariable<?> typeVars[] = getClass().getSuperclass().getTypeParameters();
    Type [] types = gen.getActualTypeArguments();
    for (int i = 0; i < typeVars.length; i++) {
      System.out.println("Generic parameter " + typeVars[i] + 
                         " is bound to " + types[i]);
    }
  }

  public static void main(String[] args) {
    new GenericClass();
  }
}

class GenericSuper<X, Y> {};
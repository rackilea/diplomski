import java.lang.reflect.*;
import java.util.*;

class A<T1, T2>
{
  Class<T2> clazz;

  A()
  {
    Type sc = getClass().getGenericSuperclass();
    Map<TypeVariable<?>, Class<?>> map = new HashMap<TypeVariable<?>, Class<?>>();
    while (sc != null)
    {
      if (sc instanceof ParameterizedType)
      {
        ParameterizedType pt = (ParameterizedType) sc;
        Type[] ata = pt.getActualTypeArguments();
        TypeVariable[] tps = ((Class) pt.getRawType())
            .getTypeParameters();
        for (int i = 0; i < tps.length; i++)
        {
          Class<?> value;
          if (ata[i] instanceof TypeVariable)
          {
            value = map.get(ata[i]);
          }
          else
          {
            value = (Class) ata[i];
          }
          map.put(tps[i], value);
        }
        if (pt.getRawType() == A.class)
        {
          break;
        }
        if (ata.length >= 1)
        {
          sc = ((Class) pt.getRawType()).getGenericSuperclass();
        }
      }
      else
      {
        sc = ((Class) sc).getGenericSuperclass();
      }
    }

    TypeVariable<?> myVar = A.class.getTypeParameters()[1];
    clazz = map.containsKey(myVar) ? (Class<T2>) map.get(myVar) : null;
  }
}

class Bar<T> extends A<T, String> {}
class Baz extends Bar<Integer> {}

class A2<T3, T1, T2> extends A<T1, T2> { }
class B<T> extends A2<Long, String, T> { }
class C extends B<Integer> { }
class D extends C { }

class Plain<T1, T2> extends A<T1, T2> {}

public class Test
{
  public static void main(String[] args)
  {
    new D();
    new Baz();
    new A<String, Integer>();
    new Plain<String, Integer>();
  }
}
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TypedReflectTest {
    public static void main(String[] args) {
        List<MyClass<?>> list = new ArrayList<MyClass<?>>();
        list.add(new MyClassInteger(123));
        list.add(new MyClassDouble(123.45));
        list.add(new MyClassString("1234"));
        System.out.println(filterMyClass(list, Integer.class));
    }

    public static List<MyClass<?>> filterMyClass(List<MyClass<?>> toFilter, Class<?> innerType) {
        List<MyClass<?>> filteredList = new ArrayList<MyClass<?>>();
        for (MyClass<?> elem : toFilter) {
            if (!elem.getInnerType().equals(innerType))
                continue;
            filteredList.add(elem);
        }
        return filteredList;
    }
}

abstract class MyClass<T> {
    private T value;
    private Class<?> innerType;

    public MyClass(T value) {
        this.value = value;
        Type superClass = getClass().getGenericSuperclass();
        innerType = (Class<?>)(((ParameterizedType) superClass).getActualTypeArguments()[0]);
    }

    public T getValue() {
        return value;
    }

    public Class<?> getInnerType() {
        return innerType;
    }

    @Override
    public String toString() {
        return "MyClass(" + value + ")";
    }
}

class MyClassInteger extends MyClass<Integer> {
    public MyClassInteger(Integer value) {
        super(value);
    }
}

class MyClassDouble extends MyClass<Double> {
    public MyClassDouble(Double value) {
        super(value);
    }
}

class MyClassString extends MyClass<String> {
    public MyClassString(String value) {
        super(value);
    }
}
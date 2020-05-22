import java.util.function.*;
import java.util.*;
import java.util.stream.*;

enum Test implements Supplier<String> {
   A, B, C;

   public String get() { return name(); }
}

class Main {

    public static <T extends Supplier<String>> List<String> getValueList(final Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                     .map(Supplier::get)
                     .collect(Collectors.toList());
    }

    public static final void main(String[] args) {
        System.out.println(getValueList(Test.class).stream()
                  .collect(Collectors.joining(",")));
    }
}
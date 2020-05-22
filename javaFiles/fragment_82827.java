import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.stream.*;

public class AnnoTest {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE_USE)
    @interface NonNull {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE_USE)
    @interface NonEmpty {}

    List<@NonNull String> list;
    Map<@NonNull Integer, @NonNull @NonEmpty Set<String>> map;
    Object plain;

    public static void main(String[] args) throws ReflectiveOperationException {
        for(Field field: AnnoTest.class.getDeclaredFields()) {
            AnnotatedType at = field.getAnnotatedType();
            System.out.println(formatType(at)+" "+field.getName());
        }
    }
    static CharSequence formatType(AnnotatedType type) {
        StringBuilder sb=new StringBuilder();
        for(Annotation a: type.getAnnotations()) sb.append(a).append(' ');
        if(type instanceof AnnotatedParameterizedType) {
            AnnotatedParameterizedType apt=(AnnotatedParameterizedType)type;
            sb.append(((ParameterizedType)type.getType()).getRawType().getTypeName());
            sb.append(Stream.of(apt.getAnnotatedActualTypeArguments())
                .map(AnnoTest::formatType).collect(Collectors.joining(",", "<", ">")));
        }
        else sb.append(type.getType().getTypeName());
        return sb;
    }
}
import com.google.common.base.Function;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.commons.lang3.reflect.TypeUtils;

public class FunkUtils { private FunkUtils() {}

    public static boolean isNullableArgument(Class<? extends Function> functionClass) throws Exception {
        Map<TypeVariable<?>,Type> typeArgs = TypeUtils.getTypeArguments(functionClass, Function.class);
        TypeVariable<?> argTypeParam = Function.class.getTypeParameters()[0];
        Type argType = typeArgs.get(argTypeParam);
        Class argClass = TypeUtils.getRawType(argType, null);
        Method applyMethod = functionClass.getDeclaredMethod("apply", argClass);
        Annotation[] argAnnos = applyMethod.getParameterAnnotations()[0];
        for (int i = 0; i < argAnnos.length; i++) {
            if (argAnnos[i] instanceof Nullable) return true;
        }
        return false;
    }
}
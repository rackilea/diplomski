import org.aspectj.lang.reflect.MethodSignature;
import java.lang.reflect.Method;

@Pointcut("within(@org.springframework.stereotype.Controller *)")
public void controller() {}

// In advice
MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
Method method = methodSignature .getMethod();
RequestMethod[] requestMethods = method.getAnnotation(RequestMapping.class).method();
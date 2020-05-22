@Aspect
@Component
public class WrappableAspect {

    @After("@annotation(annotation) || @within(annotation)")
    public void wrapper(
            final JoinPoint pointcut,
            final Wrappable annotation) {
        Wrappable anno = annotation;
        List<Parameter> keyParams = new ArrayList<>();

        if (annotation == null) {
            if (pointcut.getSignature() instanceof MethodSignature) {
                MethodSignature signature =
                        (MethodSignature) pointcut.getSignature();
                Method method = signature.getMethod();
                anno = method.getAnnotation(Wrappable.class);

                Parameter[] params = method.getParameters();
                for (Parameter param : params) {
                    try {
                        Annotation keyAnno = param.getAnnotation(Key.class);
                        keyParams.add(param);
                    } catch (Exception e) {
                        //do nothing
                    }
                }
            }
        }
    }
}
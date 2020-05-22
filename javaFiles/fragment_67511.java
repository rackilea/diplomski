@Aspect
public class Initializer {
    @Before("@annotation(your.package.magic) && target(obj) && @annotation(annotation)")
    private void initialize(A obj, magic annotation) {             
         a.init(annotation.arg);
    }
}
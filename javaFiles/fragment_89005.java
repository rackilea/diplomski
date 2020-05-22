/**
 * Silly transformer, used to hack the toString method.
 */
public class ToStringTransformer extends ClassTransformer {

    /**
     * We'll only transform subtypes of MyInterface.
     */
    @Override
    protected boolean filter(CtClass candidateClass) throws Exception {
        CtClass myInterface = ClassPool.getDefault().get(MyInterface.class.getName());
        return !candidateClass.equals(myInterface) && candidateClass.subtypeOf(myInterface);
    }

    /**
     * Hack the toString() method.
     */
    @Override
    protected void applyTransformations(CtClass classToTransform) throws Exception {
        // Actually you must test if it exists, but it's just an example...
        CtMethod toStringMethod = classToTransform.getDeclaredMethod("toString");
        classToTransform.removeMethod(toStringMethod);

        CtMethod hackedToStringMethod = CtNewMethod.make(
                "public String toString() { return \"toString() hacked by Javassist\"; }",
                classToTransform);
        classToTransform.addMethod(hackedToStringMethod);
    }

}
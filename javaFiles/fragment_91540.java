package sun.reflect;

/**
 The master factory for all reflective objects, both those in
 java.lang.reflect (Fields, Methods, Constructors) as well as their
 delegates (FieldAccessors, MethodAccessors, ConstructorAccessors).
**/

public class ReflectionFactory {


    // "Inflation" mechanism. Loading bytecodes to implement Method.invoke() and Constructor.newInstance() currently costs
    // 3-4x more than an invocation via native code for the first invocation (though subsequent invocations have been benchmarked
    // to be over 20x faster). Unfortunately this cost increases startup time for certain applications that use reflection
    // intensively (but only once per class) to bootstrap themselves. To avoid this penalty we reuse the existing JVM entry points
    // for the first few invocations of Methods and Constructors and then switch to the bytecode-based implementations.
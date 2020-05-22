// Remember that this class name tells us, it's in the default package, 
// otherwise you would have to use the fully qualified name, for example
// com.mydomain.Test

String className = "Test";

// First we need to get the correct class object

Class<?> clz = Class.forName(className);

// And from this class object, we can create a new instance, in other
// words, a "Test" object:

Test test = (Test)clz.newInstance();
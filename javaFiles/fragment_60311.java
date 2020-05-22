// Note: We load the class by specifying the fully-qualified class name!
Class<?> clazz = Class.forName("TextOutputter");

// Then, we instantiate the class.
// Note that the following method will call the no-argument constructor.
Outputter outputter = clazz.newInstance();      

// Now, we can give data to the TextOutputter object that we loaded dynamically.
outputter.write(...);
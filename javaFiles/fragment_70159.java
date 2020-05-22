// Add to the metaClass of an anstract java class
AbstractList.metaClass.woo = { 'hi there' }

// Create an instance of a class that extends this abstract class
ArrayList list = [ 1, 2, 3 ]

// Call the closure in the metaClass
println list.woo()
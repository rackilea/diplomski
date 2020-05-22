/* Add this field to class definition */
private static Object sharedObject = new Object();

/* Now in `run` method  use the object like this : */
synchronized(sharedObject) {
    //TODO : write your code here :)
}
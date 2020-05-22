Object newObj = stream.readObject();
if (newObj instanceof testobject) {
     doSomething((testobject) newObj);
} else if (newObj instanceof String) {
     doSomethingWithString((String) newObj);
} // etc.
Class<?> myClass = String.class;//Get the class from the list. For this example i used String.class
    try {
        Constructor<?> classConstructor = myClass.getConstructor(byte[].class); //Here we get the constructor we aim for. String has a constructor which accepts a byte array as parameter, so all i do is getConstructor with patameter byte[].class. 
//if your class accepts two parameters such as long and int, you will have to do .getConstructor(long.class, int.class); in the correct order ofcourse. 
        Object objectOfClass = classConstructor.newInstance(new byte[]{33,25,111,34});//here we call the constructor and we provide the parameter values it takes to it. So thats why i provide a byte array. In the case of the long and int constructor mentioned above, you will have to invoke it like this: .newInstance(214324324234,34242); 
    } catch (ReflectiveOperationException e) { //Reflective operation exception wraps up all reflection related exceptions, so we catch it instead of having to manually catch each of them. 
        e.printStackTrace();
    }
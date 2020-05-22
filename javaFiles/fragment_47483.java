if (scanner.hasNextFloat()) {
    float myFloat = scanner.nextFloat();
    String myStringFloat = Float.toString(myFloat);
    //Do stuff to your float here.
    jsonString.replace(myStringFloat, newFloatValue);
}
return jsonString.JSONFunctionToTurnThisBackIntoAnObject();
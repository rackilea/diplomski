int length = inputVector.getVectorLength() + whatToPlusVector.getVectorLength();
// You need the class of T1 to be able to create an array of it:
Class<?> clazz = inputVector.getVector().getClass().getComponentType();

T1[] array=(T[])Array.newInstance(clazz, length);
Vector <T1> result = new Vector<>(array);
// And the rest of your plus() method.
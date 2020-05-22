// instantiate a generic array
T[] result = (T[]) Array.newInstance(type, length);
// parameterized constructor of generic type, e.g. new T(String[])
Constructor<T> constructorOfT = type.getConstructor(String[].class);
// call the constructor for every position of the array
result[i] = constructorOfT.newInstance(new Object[] { args });
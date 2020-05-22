MyElementType[] myArray = { /* ... */ };
MyElementType[] result;
List<MyElementType> temp = new ArrayList<MyElementType>();

for (MyElementType element : myArray) {
    if (passesMyTest(element)) {
        temp.add(element);
    }
}

result = temp.toArray(new MyElementType[0]);
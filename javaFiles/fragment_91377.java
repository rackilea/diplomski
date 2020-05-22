public static void main(String[] args) {

HashFunction theFunc = new HashFunction(101);

String[] elementsToAdd2 = new String[101];

for (int i = 0; i <= 100; i++) {
    elementsToAdd2[i] = Integer.toString(RandomNumbers.getRandomNumberInRange(0, 15024267));
}

theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

}
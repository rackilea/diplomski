Object[] array = new Object[] {
    new Object(),
    new Object(),
    new Object(),
    new Object()};
Object[] otherArray = new Object[array.length];
Object[] clonedArray = array.clone();

System.arraycopy(array, 0, otherArray, 0, array.length);

for (int ii=0; ii<array.length; ii++) {

    System.out.println(array[ii]+" : "+otherArray[ii]+" : "+clonedArray[ii]);

}
public static void main(String[] args){   
    MyClass[] array = new MyClass[20];

    for(int i = 0; i < array.length; i++){
       array[i] = new MyClass(i, someRandomValue); // Here I used (i*3 + 2)%5
    }
    System.out.println(Arrays.toString(array));
    Arrays.sort(array);
    MyClass [] arraySorted = Arrays.copyOfRange(array, 0, 10); //take the first ten elements
    System.out.println(Arrays.toString(arraySorted));
}
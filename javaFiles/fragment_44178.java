public class ArrayReaderWriter {

    public static void main(String[] args) throws Exception {
        writeArray(20);
        readArray(20);
    }

    public static void writeArray(int arrayLength) throws IOException {
        File file = new File("arrays_" + arrayLength + "A.ser");
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        os.writeObject(array);
    }

    public static void readArray(int arrayLength) throws IOException, ClassNotFoundException {
        File file = new File("arrays_" + arrayLength + "A.ser");
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
        int[] array = (int[]) is.readObject();
        // Printing here to verify 
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
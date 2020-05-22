public static void printArray(int[] array, PrintWriter writer) {
    for(int i = 0; i < array.length; i++) {
        writer.print(array[i]);
        if(i != array.length - 1) writer.print(',');
    }
}
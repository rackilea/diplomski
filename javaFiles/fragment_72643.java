private static void printArray(String[] array) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < array.length; i++) {
        if(i > 0 && i % 4 == 0) {
            sb.append("\n");
        }
        sb.append(array[i]);
        sb.append(" ");
    }
    System.out.println(sb);
}
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[] insertArr = {10, 30, 20, 40, 60, 50, 90, 70, 80};
    Arrays.sort(insertArr);
    System.out.println("At what position you want to insert");
    int pos = in.nextInt();
    System.out.println("What element you want to insert");
    int key = in.nextInt();
    insertPosition(insertArr, pos, key);

    Arrays.stream(insertArr).forEach(System.out::println);
}

public static void insertPosition(int insertArr[], int pos, int key) {
    if (pos >= insertArr.length)
        return;
    for (int i = insertArr.length - 1; i > (pos - 1) && i < insertArr.length -1; i--)
        insertArr[i + 1] = insertArr[i];
    insertArr[pos - 1] = key;
}
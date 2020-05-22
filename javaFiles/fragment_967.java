public static void recurse(int[] newArray, int i) {
    for (int j = i; j < newArray.length; j++) {
        newArray = swap(newArray, i, j);
        if (i < (newArray.length - 1)) {
            recurse(newArray, i + 1);
        }
        if (i == (newArray.length - 1)) {
            display(newArray);
        }
    }
}

private static int[] swap(int[] a, int i, int j) {
    int[] newArray = a.clone();
    int temp = newArray[i];
    newArray[i] = newArray[j];
    newArray[j] = temp;
    return newArray;
}

public static void display(int[] Array) {
    for (int i : Array) {
        System.out.print(i);
    }
    System.out.println();
}


public static void main(String args[]) {
    recurse(new int[]{1, 2, 3}, 0);
}
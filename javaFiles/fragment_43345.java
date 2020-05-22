public static int[] reverse(int[] list) {
    int[] newList = new int[list.length];

    for (int i = 0; i < list.length; i++) {
      newList[i] = list[list.length - 1 - i];
    }

    return newList;  
}
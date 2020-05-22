public int[] copyArr(int[] arr) {
      int length = arr.length;
      int[] newArr = new int[length];

      for (int i = 0; i < length; i++) {
        newArr[i] = arr[i];
      }

      return newArr;
}
String str = "BA34CD567";
char[] arr = str.toCharArray();

for (int i = 0; i < arr.length - 1; i += 2) {
    char temp = arr[i];
    arr[i] = arr[i + 1];
    arr[i + 1] = temp;
}

System.out.println(arr);
public static boolean isPalindrome(int[] num, int index) {
    int length = num.length;
    int end = --length;
    end -=index;

    print(num, index, end);

    if (length == 0 || length == 1)
        return true;

    if (index >= end)
        return true;

    if(num[index]!=num[end])
        return false;

    return isPalindrome(num, index+1);
}

private static void print(int num[], int index, int end) {
    for (int i = 0; i < num.length; i++) {
        if(i == index || i == end)
            System.out.print("["+num[i]+"]");
        else
            System.out.print("_,");
    }

    System.out.println();
}
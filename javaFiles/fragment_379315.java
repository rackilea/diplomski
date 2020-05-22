public static void printUnderline(String s, char c){
    char[] arr =s.toCharArray();
    for(int i=0;i<arr.length;i++)
        if(arr[i] == ' ')
            System.out.print(' ');
        else
            System.out.print(c);
}
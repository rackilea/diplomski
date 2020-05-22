public static void main(String [] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();

    String arr[] = input.split (" ");
    if (arr.length > 1)
        System.out.println(arr[1] +","+ arr[0]);
}
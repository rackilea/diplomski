public static void main(String[] arguments) {
    String time = "10:50:45";
    String [] arr = time.split(":");

    if (containsNumbers(arr)) {
        System.out.println("Time contained a number!");
    } 
    //You can put an else if you want something to happen when it is not a number
}

private static boolean containsNumbers(String[] arr) {
    for (String s : arr) {
        if (!isNumeric(s)) {
            return false;
        }
    }
    return true;
}

public static boolean isNumeric(String str) {
    return str.matches("-?\\d+(.\\d+)?");
}
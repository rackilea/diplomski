public class Main {
    public static void main(String[] args) {
        char[] array = {'H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd', '!'};
        String temp = "";
        for (int i = 0; i < array.length; i++) {
            if (temp.indexOf(array[i]) == -1)
                temp = temp + array[i];
        }
        char[] reslut = temp.toCharArray();
    }
}
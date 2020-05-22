public static void main(String[] args){
    System.out.println("Enter a string: ");
    String str = IO.readString();
    int count = 0;
    String result = "";

    for (int i=0; i < str.length(); i++) {
        char a = str.charAt(i);
        count = 1;

        while (i + 1 < str.length() && str.charAt(i) == str.charAt(i+1)) {
            count++;
            i++;
        }

        if (count == 1) {
            result = result.concat(Character.toString(a));
        } else {
            result = result.concat(Integer.toString(count).concat(Character.toString(a)));
        }
    }

    IO.outputStringAnswer(result);
}
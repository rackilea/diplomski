for (i = 0; i < text.length(); i++) {
    if (text.charAt(i) == ' ')
        System.out.print(" ");
    else if (Character.isUpperCase(text.charAt(i)))
        System.out.print("0");
    else {
        System.out.print("1");
    }
}
public static void main(String[] args) {
        String str = "aaaaa";

        int count = str.length() - str.replaceAll(String.valueOf(str.charAt(0)), "").length();
        if(count == str.length())
            System.out.println("All characters in a given String are same");
}
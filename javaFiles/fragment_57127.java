public  class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(text);
        for(int j=0;j<text.length();j++) {
            char firstLetter = text.charAt(0); //get the first letter
            text = text.substring(1); //remove the first letter from the input string
            text = text + firstLetter;
            System.out.println(text);
        }
    }
}
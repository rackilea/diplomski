public static void main(String [] args) {
    String [] options = args[0].split(",",15);
    for(int i = 0; i < options.length; i++) {
        System.out.printf("option %d = [%s]\n", i, options[i]);
    }
}
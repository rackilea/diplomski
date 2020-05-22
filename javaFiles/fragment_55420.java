public static void main (String[] args) throws Exception {
    String input = "X000-X";
    String replacement = "123";
    int ls = input.lastIndexOf("-");
    int fs = input.indexOf("-");
    System.out.println("Extracted Number: " + (fs < 1 ? input.substring(1) : 
                                                        input.substring(1,fs)));
    System.out.println("Final Output: " + input.substring(0,1) + replacement + 
                       (ls != fs || fs == input.length() - 2 ? input.substring(ls) : ""));
}
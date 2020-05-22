public static void main(String[] args) {
    String[] noHide = {"chflags", "nohidden","~/Library"};
    try {
        Runtime.getRuntime().exec(noHide);
    } 
    catch (Exception e) {
        }
    }
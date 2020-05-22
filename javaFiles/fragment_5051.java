class Main {
    public static void main(String[] args) {
        String line = "A:B:C:D:E:F:G:H:::::" ;
        int delimiterCount = 12 ; 

        String[] values = line.split(":", -1);
        if (values.length != delimiterCount + 1) {
            System.out.println("Invalid Line");
        } else {
            System.out.println("Valid Line");
        }
    }
}
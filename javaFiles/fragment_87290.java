public class Tester2 {

    /**
     * @param args
     */
    public static void main(String[] args) {

        boolean state = true;
        while(state) {

            System.out.println("Please enter your text");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            if(input.contains("load")) {
                String fileName = getFileName(input);
                if(fileName != "" || fileName!= null) {
                    load(fileName);
                }
            }else{

            }

        }

    }

    private static String getFileName(String input) {
        String values[] = input.split("\\s+");
        String fileName = "";
        for(String s : values) {
            if(s.indexOf(".") > 0) {
                fileName = s;
                break;
            }
        }
        return fileName;
    }

}
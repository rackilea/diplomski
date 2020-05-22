public static final int STARTER = "3";

public static void main(String[] args) {
    boolean read = false;
    try {
        Scanner s = new Scanner(new File("input.txt"));
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (!read) {
                if (Integer.parseInt(line) == STARTER) {
                    read = true;
                }
            } else {
                System.out.println(line); // or save to a list or ...
            }
        }
    } catch (Exception e){
        System.out.println(e);
    }
}
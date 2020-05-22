public static void main(String[] args) {

    FileReader in = null;
    FileWriter out = null;
    File fp = new File("D:/readFrom.txt");
    Scanner sc = null;
    try {
        sc = new Scanner(fp);
        String str = "";
        while (sc.hasNext()) {
            str = sc.next();
            if (str.contentEquals("Coding")) {
                System.out.println(str);
                if (sc.nextInt() == 1) {
                    System.out.println("Coding is set.");
                } else {
                    System.out.println("Coding is not set.");
                }
            }
        }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {

        try {
            if (out != null)
                out.close(); // you should close it on finally
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if (in != null)
                in.close(); // you should close it on finally
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            if (sc != null)
                sc.close(); // you should close it on finally
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
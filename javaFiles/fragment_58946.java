public static void main(String[] args) throws IOException {

    FileWriter fw = null;
    try {
        fw = new FileWriter("C:/Users/MYPC/Desktop/abcd.txt");
        String str;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter your lines");
            str = sc.nextLine();

            if (!str.equals("stop")){
                fw.write(str);
            }
            fw.write("\n");

        } while (!str.equals("stop"));

    } catch (Exception ex) {
        System.out.println(ex);
        // Logger.getLogger(FileReadLine.class.getName()).log(Level.SEVERE,
        // null, ex);
    }finally{
        if(fw != null){
            fw.close();
        }
    }
}
public static void main(String[] args) {

    File file1 = new File ("zips.txt");
    try (Scanner stdin = new Scanner (file1);){
        String str = stdin.next();

        System.out.println(str);
    } catch (FileNotFoundException e) {
        /* handle */
    } 
}
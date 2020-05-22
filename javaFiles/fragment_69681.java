public static void main(String[] args) throws Exception {
    File file = new File("D:/GC/Reverse/B-Small.txt");
    FileWriter fw = new FileWriter(file);
    BufferedWriter bw = new BufferedWriter(fw);
    Scanner sc = new Scanner(new File("D:/GC/Reverse/B-small.in"));
    int testCaseCount = Integer.parseInt(sc.next());
    //System.out.println("Test cases are:"+testCaseCount);
    int i = 0;

    while (sc.hasNextLine()) {
        String input = sc.nextLine();
        //System.out.println(input);
        String output = "";
        String[] array = input.split(" ");
        for (int j = array.length - 1; j >= 0; j--) {
            output += array[j] + " ";
        }
        if (!"".equals(output)){
            bw.write("Case #" + (i + 1) + ": " + output.trim() + "\r\n");
        }

    }

    bw.close();
    sc.close();
}
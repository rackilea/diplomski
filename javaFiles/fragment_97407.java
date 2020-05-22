public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new File("Testing.txt"));

    while(sc.hasNext()){
        String line = sc.nextLine();
        String arr [] = line.split(" ");

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i].charAt(0))) {
                out.append("\u001B[32m").append(arr[i]).append(" ");
            } else {
                out.append("\u001b[0m").append(arr[i]).append(" ");
            }
        }

        System.out.println (out);
    }
}
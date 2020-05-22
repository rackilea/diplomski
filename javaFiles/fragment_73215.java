public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        for (int i =0; i < num; i++){
            int n = in.nextInt();
            string ch = n.toString();
            string output = "";
            for (int j = 0; j < ch.length; j ++){
                output = ch[j] + output;
            }
            System.out.println(output);
        }
}
public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String askWork = "";
        while (askWork.isEmpty()) {
            System.out.println("Enter a word:");
            askWork = input.readLine().trim();
        }

        String workPlace = askWork.substring(0,1).toUpperCase() + askWork.substring(1);

        System.out.println(workPlace);
    }
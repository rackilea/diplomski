public static void main(String[] args) throws FileNotFoundException {
        File file = new File("names.txt");
        Scanner my_input = new Scanner(file);

        String[] names = new String[20];
        int i = 0;
        while (my_input.hasNext()) {
             String t =  my_input.nextLine();
             if(!t.equals("-1"))
             names[i++] = t;
        }


        System.out.println("Enter name");
        String nameToCheck = my_input.nextLine();
        for (String temp : names) {
            if (temp.equals(nameToCheck)) {
                System.out.println("FOund");
            }
        }
        my_input.close();
    }
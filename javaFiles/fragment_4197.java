public static void main(String[] args) throws FileNotFoundException {
            File file = new File("names.txt");
            Scanner my_input = new Scanner(file);

            ArrayList<String> names = new ArrayList<>();

            while (my_input.hasNext()) {
                 String t =my_input.nextLine();
                 if( !t.equals("-1"))
                 names.add(t);

            }


            System.out.println("Enter name");
            String nameToCheck = my_input.nextLine();
            if (names.contains(nameToCheck)) {
                System.out.println("Found");
            }
            my_input.close();
        }
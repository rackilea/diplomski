private static void Register() throws FileNotFoundException{
        try{            

            FileWriter fw = new FileWriter("info.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);           


            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a username: ");
            String username = scan.nextLine();
            System.out.println("Enter a password: ");
            String password = scan.nextLine();
            out.println(username + " " + password);

            out.flush();


        }catch(IOException e){
            e.printStackTrace();
        }
    }
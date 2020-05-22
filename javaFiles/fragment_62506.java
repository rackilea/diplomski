public static void main(String[] args) throws FileNotFoundException
        {
            PrintWriter out = new PrintWriter("hello.txt");
            out.println("Hello, World");
            out.close();
            File readFile = new File("hello.txt");
            Scanner in = new Scanner(readFile);
            ArrayList<String> x = new ArrayList<String>();
            int y = 0;

            while (in.hasNext())
            {
                x.add(in.next());
                y++;
            }

            in.close();  

            if (x.size() == 0)
            {
                System.out.println("Empty.");
            }
            else
            {
                System.out.println(x.get(y-1));
            }

        }
    }
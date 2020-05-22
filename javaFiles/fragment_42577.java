public ArrayList<Boolean> pro(String b) throws IOException, Exception {
        ArrayList<Boolean> ar = new ArrayList<Boolean>();
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-jar",
                    "myjar.jar");

            pb.directory(new File("path to myjar"));
            Process proc = pb.start();

            Scanner in = new Scanner(proc.getInputStream());
            PrintWriter out = new PrintWriter(proc.getOutputStream());

            // Read user input
            out.println(b);
            out.flush();
            String response = new String();

            // Read the response
            for (int i = 0; i < b.length(); i++)
                response = in.nextLine();

            in.close();
            out.close();

            StringTokenizer st = new StringTokenizer(response);
            while (st.hasMoreTokens()) {
                String bol = st.nextToken();

                if (bol.equals("true"))
                    ar.add(true);
                else
                    ar.add(false);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ar;
    }
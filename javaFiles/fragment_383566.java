public static void main(String[] args) {

        try {
            File dir = new File("/root/");
            Runtime runtime = Runtime.getRuntime();
            Process p = runtime.exec("mysqldump database_name >/path-for-backpfile/database.sql", null, dir);


            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = reader.readLine();


            while (line != null) {
                System.out.println(line);

                line = reader.readLine();
            }

        } catch (IOException e1) {
        }

    }
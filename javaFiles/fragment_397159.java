public static void showFiles(File[] files) throws IOException {
    String line = null;

    try{
        for (File file : files) {
            if (file.isDirectory()) {
                String fileName = "Directory: " + file.getName();
                System.out.print(fileName);
                showFiles(file.listFiles()); // Calls same method again.
            } else {
                System.out.print("\tFile: " + file.getName() + file.toString());
                //System.out.println("Directory: " + file.getName());
                BufferedReader in = new BufferedReader(new FileReader(file));
                while((line = in.readLine()) != null)
                {
                    System.out.print("\t Content:" + line);
                }
                in.close();
                System.out.println();
            }
        }
    }catch(NullPointerException e){
        e.printStackTrace();
    }
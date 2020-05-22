public static int read(String path, int x, int y, int z, Player player) {
        int value = -1;
        try {
            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = "";       
            //Read File Line By Line
            int index = -1;
            while ((strLine = br.readLine()) != null) {
                index = strLine.indexOf(x + "_" + y + "_" + z);
                if (index != -1) {
                    value = index;
                    break;
                }
            }
            //Close the input stream
            in.close();
        } catch (Exception exception) {//Catch exception if any
            exception.printStackTrace();
        }
        return value;
    }
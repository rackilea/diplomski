public static void read(BufferedReader br) throws Exception {
            long length = 0;
            String s = "";
            while (true) {
                    String ss = br.readLine();
                    if (ss == null) {
                            break;
                    }
                    s += ss;
                    length += ss.length();
            }
            System.out.println("Read: " + (length/1024/1024) + " MB");
    }
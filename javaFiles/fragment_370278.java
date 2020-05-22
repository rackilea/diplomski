FileInputStream fin;
        fin = new FileInputStream("file.txt");
        DataInputStream in = new DataInputStream(fin);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        List<char[]> list = new ArrayList<char[]>();
        String line;
        while ((line = br.readLine()) != null) {
            if(!line.isEmpty()) list.add(line.toCharArray());
        }
String sCurrentLine;

        br = new BufferedReader(new FileReader("C:\\testing.txt"));

        while ((sCurrentLine = br.readLine()) != null) {
            System.out.println(sCurrentLine);
        }
BufferedReader fileInput = new BufferedReader(new FileReader("example.txt"));
    String s;
    while ((s = fileInput.readLine()) != null) {
        for (char c : s.toCharArray()) {
            //Read into array
        }
    }
    fileInput.close();
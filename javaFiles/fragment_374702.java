try {
        BufferedReader in = new BufferedReader(new FileReader("plaintext.txt"));
        String inputDataLine;
        while ((inputDataLine = in.readLine()) != null) {
            if (!(inputDataLine.contentEquals(" "))) {
                System.out.println("What you want to do with a paragraph line");
            } else {
                System.out.println("What you want to do with a paragraph seperator");
            }
        }
        in.close();
    } catch (IOException e) {
    }
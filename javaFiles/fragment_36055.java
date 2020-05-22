int x = 10;
    BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("utfil.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }

    writer.write(x);
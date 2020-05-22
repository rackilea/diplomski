try {

        BufferedReader br = new BufferedReader(
                new FileReader("C:/Users/Sei_Erfolgreich/Desktop/convert.txt"));
        String zeile;

        try {
            File newTextFile = new File("C:/Users/Sei_Erfolgreich/Desktop/convert2.txt");
            FileWriter fw = new FileWriter(newTextFile);
            while ((zeile = br.readLine()) != null) {
                zeile = zeile.replaceAll("\",\"", "\uffff").replaceAll(",",
                        "").replaceAll("\uffff", "\",\"");
                System.out.println(zeile);
                fw.write(zeile);
            }


            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    }
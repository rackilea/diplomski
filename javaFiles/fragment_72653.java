public static List<String> getFile(String namn) throws FileNotFoundException {
    String userHomeFolder = System.getProperty("user.home");
    String filnamn = userHomeFolder + "/Desktop/" + namn + ".txt";
    int counter = 0;

    // this list will keep all sentence
    List<String> allParts = new ArrayList<String>(); s

    Scanner inFil = new Scanner(new File(filnamn));

    // part keeps single sentence temporarily
    String part = "";
    while (inFil.hasNextLine()) { 
        String fråga = inFil.nextLine(); //reads next line
        if(!fråga.equals("")) {       // if line is not empty then
                part += " " + fråga;      // add it to current sentence
            } else {                  // else     
                allParts.add(part);       // save current sentence
                part = "";                // clear temporary sentence
            }

        }
        inFil.close();
        return allParts;

    }
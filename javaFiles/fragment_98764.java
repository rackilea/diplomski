public static void main(String[] args) throws Exception {

        File file = new File("path");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        String[] data = null;
        ArrayList<Number> numbersList = new ArrayList<>();
        ArrayList<String> wordsList = new ArrayList<>();

        //Remove white space and split by comma
        while ((str = br.readLine()) != null) {
            str = str.replaceAll(" ", "");
            data = str.split(",");
        }

        assert data != null;
        for (String entry : data) {

            //check for floats
            if(entry.contains(".")){
                try {
                    //Check if we can parse 
                    float d = Float.parseFloat(entry);
                    //Add to numbers list.
                    numbersList.add(d);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            //Else, handle the rest
            } else {
                try {
                    int number = Integer.valueOf(entry);
                    numbersList.add(number);
                } catch (NumberFormatException e) {
                    wordsList.add(entry);
                }
            }
        }
        System.out.println(numbersList);
        System.out.println(wordsList);
    }
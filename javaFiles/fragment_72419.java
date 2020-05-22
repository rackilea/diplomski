private  String[][] expectedTitles(String titleName) throws IOException {
    String[][] testData = null;
    String[] data = null;
    String line = null;

    BufferedReader br = new BufferedReader(new FileReader("...\\yourfilepath\\data.csv"));


    while ((line = br.readLine()) != null){

        data = line.split(",");
       testData= new String[1][data.length];

        if(data[0].equalsIgnoreCase(titleName))
        {
            for(int i =0; i<data.length; i++)

            {

            testData[0][i] = data[i];

            }

        break;
        }
    }
    return testData;        
}
public static Properties getProps(String pathToNames, String pathToNumbers){

    Properties prop = new Properties();

    try{
        File names = new File(pathToNames);
        BufferedReader theNames = new BufferedReader( new InputStreamReader (new FileInputStream(names)));
        File numbers = new File(pathToNumbers);
        BufferedReader theNumbers = new BufferedReader( new InputStreamReader (new FileInputStream(numbers)));

        String name;
        String number;
        while(((name = theNames.readLine())!= null)&&((number = theNumbers.readLine())!= null)){
            prop.put(number, name);
        }
        theNames.close();
        theNumbers.close();

    }catch(Exception e){
        e.printStackTrace();
    }
    return prop;
}
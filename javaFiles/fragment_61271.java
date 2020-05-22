public static void conceptHashMap() {
int len,i=0;
double dVal=0.0;
String strLine;
String conceptSearch = "line1";     // will be a key in hashmap

try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

    while ((strLine = br.readLine()) != null) {
        String[] dims = strLine.split(" ");
        len=dims.length;
        if(dims[i++].equals(conceptSearch)){
            while(--len>0) {
                dVal=Double.parseDouble(dims[i++]);
                hmValues1.add(dVal);
            }
            hm1.put(conceptSearch, hmValues1); 
            for (Map.Entry<String, List<Double>> entry : hm1.entrySet()) {
                String key = entry.getKey();
                List<Double> hmvalues1 = entry.getValue();
                System.out.println("key value pair");
                System.out.println("Key = " + key);
                System.out.println("Values = " + hmvalues1);
                // simply iterate the list to get each single value 
                for(Double hmvalue : hmvalues1){
                      System.out.println(hmvalue);
                }

            }
            break;  
        }
        i=0; 
    }
} catch (IOException e) {
    e.printStackTrace();
    }
}
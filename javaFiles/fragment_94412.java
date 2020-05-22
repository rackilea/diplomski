public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.next();
            CO2Data[] aDataArray  = null
            aDataArray = readData(filename); 
            if(aDataArray != null) {
               for(int i = 0; i < aDataArray.length; i++) {
                    System.out.println("Country:" + aDataArray[i].getCountry());
                    System.out.println("CO2 Level:" + aDataArray[i].getTotalCO2());
                }
            }
        }
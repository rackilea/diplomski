String [] collection = {"Apple","Banana","Carrot"};
        printArray(itemCombinator(collection));


public static void printArray(String[] toPrint){
        System.out.println("Combination Result:");
        for (int i = 0; i < toPrint.length; i++) {
            System.out.println(toPrint[i]);
        }
    }


public static String[] itemCombinator(String[] array){
        int len = array.length;
        String [] resultArray;
        String result = "";
        int [][] bin = binaries(len);
        for (int i = 0; i < bin.length; i++) {
            String comb= "";
            for (int j = 0; j < len; j++) {
                if(bin[i][j] == 1){
                    comb+=array[j]+" ";
                }
            }
            result += comb+"-";
        }
        resultArray = result.split("-");
        return resultArray;
    }
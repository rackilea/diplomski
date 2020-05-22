public class SplitAndKeepQuotedValuesCommas {

    public static void main(String[] args) {
        String source = "11020199,Abc Germany ,aduz,,444,bieb,dc,2 ,2222.00,whatever 5dc,222.22,22.00,\"\"98,00\"\",\"\"12,00\"\",21-09-2018,06:00";

        // split the String by comma
        String[] justValues = source.split(",");

        // print all items in the result
        for (String s : justValues) {
            System.out.println(s);
        }

        // prepare a List for all the values
        List<String> resultList = new ArrayList<String>();

        // then go through the values
        for (int i = 0; i < justValues.length; i++) {
            // and check if there is a String that begins with double double quotes
            if (justValues[i].startsWith("\"\"")) {
                /*
                 * if there is one, remove the double quotes from it and its successor,
                 * then concatenate them with a comma in between and add the result to the list
                 */
                String merged = justValues[i].replace("\"\"", "") + "," + justValues[i + 1].replace("\"\"", "");
                resultList.add(merged);
            /*
             * since there are still values with trailing double double quotes,
             * only add values without because they have already been added inside the merged value
             */
            } else if (!justValues[i].endsWith("\"\"")) {
                resultList.add(justValues[i]);
            }
        }

        resultList.forEach(value -> {
            System.out.println(value);
        });
    }
}
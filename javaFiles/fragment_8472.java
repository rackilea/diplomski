public class Excel {

        private static Scanner sc;
        public static void main(String[] args) throws FileNotFoundException {
            List<String> transactions = new ArrayList<String>();
            String str1,str2=null;
            String addArray = null;
            sc = new Scanner(new File("bc_dataset.csv"));
            str1=sc.nextLine();
            String []attributes = str1.split(","); // split the attributes by `,`. This will return array of String [age,meno-pause,tumor-size,...]
              while (sc.hasNextLine())
                {
                    String str2 = sc.nextLine();
                    String []linesplit = str2.split(","); // split the line by `,`. This will return array of String [30-39,premeno,30-34....]
                    // loop over both arrays and add them together 
                    for(int i = 0; i<attributes.length; i++){
                       finalline = finalline+attributes[i]+"="+linesplit[i]+",";
                    }
                    // this will add extra `,` in the end of string which I leave on you to escape 
                    transactions.add(finalline); // add final line to the list
                    System.out.println(transactions);
                }
        }
BufferedReader br = null;
try {
    br = new BufferedReader(new FileReader("temp.txt"));
    String line = null;


    while ((line = br.readLine()) != null) {
        StringTokenizer  st = new StringTokenizer(line);

        String sellerName = st.nextToken();
        String salary = st.nextToken(); 
        String totalSale =st.nextToken(); 
        double percentage  = 0.15;

        double  SaleAfterPercentage = (Double.parseDouble(totalSale)) * percentage; 
        //value of the total salary 
        double  finalSalary = Double.parseDouble(salary) +  SaleAfterPercentage ; 


    System.out.println(sellerName);

    System.out.println(finalSalary);
     System.out.println(totalSale);
    }


} catch (Exception e) {
    e.printStackTrace();

} finally {
    try {
        if (br != null) {
            br.close();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        }
    }
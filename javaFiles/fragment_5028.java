public static String[] readPurchaseOrder(Scanner sc) {
    final String DELIMITER = "@";
        List<String> results = new ArrayList<>();
        try {           
            while (sc.hasNext()) {
                sc.useDelimiter(DELIMITER);
                String data = sc.next();               
                results.add(data);  // add the line to the list
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close(); 
        // convert the list to an array and return it.
        return results.toArray(new String[results.size()]);
    }
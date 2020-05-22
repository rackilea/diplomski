public static void main(String[] args) throws XPathExpressionException, 
                        ParserConfigurationException, SAXException, IOException {

        String Queries[]={
                "//Employees/Employee/Firstname/City/@value",
                "//Employees/Employee/Firstname/Lastname/@value"
        };

        List<NodeList> results = new ArrayList<NodeList>();
        for (int x =0; x < Queries.length; x++){
                String query = Queries[x];
                QueryXML process = new QueryXML(query);
                results.add(process.query());
        }
  }
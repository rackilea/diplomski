public static NodeSet getCustomers(String query){
    List<Customer> l=getCustomersFromMyDatabase(query);
    BasicNodeSet bns=new BasicNodeSet();
    putCustomersIntoNodeSet(bns,l);
    return bns;
}
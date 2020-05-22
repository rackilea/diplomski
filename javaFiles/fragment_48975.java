private static Collection<? extends Sales_person> convertSalesPersons(ArrayList<Sales_personRef> sales_persons) {
    List<Sales_person> persons = new ArrayList<Sales_person>();
    for (Sales_personRef sales_personRef : sales_persons) {
        persons.add(converSalesPersonRefToSalesPerson(sales_personRef));
    }
    return persons;
}
private static Sales_person converSalesPersonRefToSalesPerson(Sales_personRef sales_personRef) {
    //implement the conversion here
    return new Sales_person();
}
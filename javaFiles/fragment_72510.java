public void printList(Object obj){
    List<?> list = (List<?>)obj;
    Object firstElement = list.get(0);
    if (firstElement instanceof Customer) {
        printCustomers((List<Customer>)list);
    } else if (firstElement instanceof Product) {
        printProducts((List<Product>)list);
    } //...
}
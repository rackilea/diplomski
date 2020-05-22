Scanner scanner = new Scanner(System.in);  

// Ask users for quantities 
PromptCustomerQty(customer, ProductList, scanner );

// Ask user for payment method
PromptCustomerPayment(customer, scanner );

//close the scanner 
scanner.close();
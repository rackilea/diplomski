String endOfSupplier = "!"; // this can be any thing
while((line = in.readLine()) != null){
    if (line.equals(endOfSupplier)){ // end of supplier
        suppliers.add(supplier); // add supplier to suppliers
        supplier = null; // set to null to show that we are done with it
    }
    if (supplier == null){ // make new supplier when it's null
        supplier = new Supplier(line); // parse phone # to supplier
    }
    else {
        supplier.addProduct(line); // make method that turns string into product and add it to supplier
    }
}
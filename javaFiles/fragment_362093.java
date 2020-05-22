finally {

    this.productName="The product name has been modified in the finally block.";
    System.out.println("Product name in the finally block : "+this.productName);

    return this.productName;  // Note: This is bad idea
}
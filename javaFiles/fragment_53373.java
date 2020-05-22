public Order(String ProductName, double Price, int Quantity){
     //calling from parameter 
    this.ProductName = ProductName;
    this.Quantity = Quantity; //receving the three parameters 
    this.Price = Price;
    OrderNum++;
    this.calculate();
}

public Order(String ProductName, double Price, int Quantity, double Discount){
    this.ProductName = ProductName;
    this.Price = Price;
    this.Quantity = Quantity;
    this.Discount = Discount;
    OrderNum++;

    if (Discount < 100){  // Will run if the Discount is < 100

         this.Discount = Discount;//assigning this to discount parameter to its instance variable 
        isDiscounted = true;
    }
    else {
        isValidOrder = false;

        Message = "ERROR: the discount value:"+ Discount +" is not valid";

    }
    this.calculate();
}
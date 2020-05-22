public String toString (){
    return  "Name of the Snack: " + name + "\n" +
            "Name of the Company: " + comp + "\n" +
            "Price before discount: " + this.price+ "\n" +
            "Price after discount: " + updatedPrice(this.price) + "\n";
}
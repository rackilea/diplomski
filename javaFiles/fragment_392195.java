public Appliance(String idNumber, String name, String brand, String type, String category, int quantity, float price) { 

    super(idNumber, name, category, quantity, price);
    this.brand = brand;
    this.type = type;
    this.category = category;
}
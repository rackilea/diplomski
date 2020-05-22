public int getProductCount(String pName) throws IllegalArgumentException {
    int count = 0;

    if (pName == null) {
        throw new IllegalArgumentException();
    }

    for (Product item : this.vending) {
        //Assuming the instance variable of your Product class is called name
        //Also assuming name is private and you have a getter method in your Product class
        if (item.getName().equalsIgnoreCase(pName)) {
            count++;
        }
    }
    return count;
}
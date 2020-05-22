@Override
    public String toString() {
        String returnString = "Inventory:\n";
        for(FoodItem item : inventory) {
            returnString += item.toString() + "\n";
        }
        return returnString;
    }
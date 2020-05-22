@Override
    public String toString() {
        String returnString = "Inventory:\n";
        for(int i=0;i<numItems;i++)
            returnString += inventory[i].toString() + "\n";
        return returnString;
    }
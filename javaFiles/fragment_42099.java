class Cell {
    // your other code

    @Override
    public void String toString() {
        return "shipment: " + shipment + "; cost: " + cost;
    }
}

class Row{
    ArrayList<Cell> cellList = new ArrayList<Cell>();

    public Row(Integer[] warehouse) {

        for(int value: warehouse) 
            cellList.add(new Cell(value, 0));

    }

  @Override
    public void String toString() {
        return cellList.toString();
    }

}
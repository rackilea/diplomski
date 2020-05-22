itemProperty().addListener((obs,oldv,newv)->{
    System.out.println("change: "+getIndex()+", newv "+(newv != null?newv.getIsbn():"null")+", oldv: "+(oldv != null?oldv.getIsbn():"null"));
}

protected void updateItem(Book item, boolean empty){
        super.updateItem(item, empty);
        System.out.println("update item: "+(item!=null?item.getIsbn():"null"));
}
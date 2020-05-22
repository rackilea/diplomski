private int checkItemsSelected(){
    int count=0;
    for(TreeItem item:rootItem.getChildren()){
        if(((CheckBoxTreeItem)item).isSelected()){
            count++;
            System.out.println("item: "+item.getValue().toString());
        }
    }
    return count;
}
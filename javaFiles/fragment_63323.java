private boolean checkItemIsSelected(String name){
    for(TreeItem item:rootItem.getChildren()){
        if(item.getValue().toString().equals(name)){
            return ((CheckBoxTreeItem)item).isSelected();
        }
    }
    return true;
}
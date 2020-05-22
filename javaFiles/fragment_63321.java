private boolean checkAllItemsSelected(){
    for(TreeItem item:rootItem.getChildren()){
        if(!((CheckBoxTreeItem)item).isSelected()){
            return false;
        }
    }
    return true;
}
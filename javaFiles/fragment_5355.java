@UiHandler("Up")
void UpClick(ClickEvent e) {
    ListBox item;
    int i=item.getSelectedIndex();
    if(i>0){
        // add duplicated item in the list
        item.insertItem(item.getItemText(i),i-1);

        // delete the old occurence of this item
        item.removeItem(i+1);
    }
}


@UiHandler("Down")
void DownClick(ClickEvent e) {
    int i=item.getSelectedIndex();
    if((i!=-1) && (i<item.getItemCount()-1)) {
        item.insertItem(item.getItemText(i),i+2);

        item.removeItem(i);
    }
}
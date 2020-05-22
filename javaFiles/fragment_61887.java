if(isChecked){
        selectedItems.add(indexSelected);
    }
    else if(selectedItems.contains(indexSelected)){
       //This line is giving arrayIndexOutOfBounds exception after unchecking a checkeditem
        selectedItems.remove(selectedItems.indexOf(indexSelected)); //<--Add this
    }}
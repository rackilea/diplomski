for (int i = 0; i < items.size(); i++) {
    items.get(i).displayedDays++;
}

int i = 0:
while (i < items.size()) {
    if(items.get(i).isRotten()) {
        items.remove(i);
        // don’t increment our counter here because now 
        // we’ve changed what object exists in the ArrayList 
        // at this index position
    } else {
        // only increment our counter if the item in that index
        // is good, so we can now move on to check the next item
        i++;
    }
}
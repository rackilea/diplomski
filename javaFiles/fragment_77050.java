// iterate over smaller list 
for(int i = 0; i < SmallerList.size(); i++) {
    TotalList.get(i).setText(SmallerList.get(i));    
}

// set remaining items
for (int i = SmallerList.size(); i < TotalList.size(); i++) {
    TotalList.get(i).setText("---");
}
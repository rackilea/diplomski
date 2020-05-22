if (item.isFound()==1){
    viewHolder.layoutList.setBackgroundColor(Color.parseColor("#60ad5e"));
} else if (item.isSearching()==1){
    viewHolder.layoutList.setBackgroundColor(Color.parseColor("#ff9d3f"));
} else {
    // reset the color back to default
}
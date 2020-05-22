@Override
public int getItemCount() {
    return toptitles.length + 1; 
   // as i have only layout at the top and the remaining size equals the length of the array toptitles.So the overall length would be 
   //number of views of layout1 + number of views of layout2
}
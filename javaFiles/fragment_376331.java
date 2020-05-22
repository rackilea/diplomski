if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB_MR2) 
{ 
    display.getSize(size); 
} 
else 
{ 
    size.set(display.getWidth(), display.getHeight()); 
}
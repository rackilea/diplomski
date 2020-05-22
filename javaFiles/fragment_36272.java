for(int i = 0; i < parent.getChildCount(); i++){
    View child = parent.getChildAt(i); 
    if(child instanceof TextView){       
        # ... do something with the text view
    }              
}
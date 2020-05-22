private boolean flag = true;

private void setvisible(){
    flag = true;
    yourView.setVisibility(View.VISIBLE); 
    // save the flag
}

private void setInvisible(){
    flag = false;
    yourView.setVisibility(View.INVISIBLE); 
    // save the flag
}
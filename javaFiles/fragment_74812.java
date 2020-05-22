private int p = 1; //moved 

@Override
public void onClick(View v) {
    // TODO Auto-generated method stub

    if(p == 9) {
        Toast.makeText(context, "You have reached to maximum number", Toast.LENGTH_LONG).show();
        return ;
    }
    else {                              
        p = p+1;                        
        holder.textViewQuantity.setText(""+p);                      
    }
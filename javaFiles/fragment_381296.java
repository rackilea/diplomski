mSolved = (Button) itemView.findViewById(R.id.book_solved); 
mSolved.setText(g.getColorvalue()); 

boolean IS_BLUE = false;
boolean IS_RED = false;

if("Blue".equals(holder.mSolved.getText())){
   mSolved.setBackgroundColor(BLUE);
   IS_BLUE = true;
}
if("Red".equals(holder.mSolved.getText())){
   mSolved.setBackgroundColor(RED);
   IS_RED  = true;
}

mSolved.setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View v) {

     if(IS_BLUE)
     {
     mSolved.setBackgroundColor(RED);
     IS_RED  = true;
     IS_BLUE = false;
     }
    else if(IS_RED)
    {
    mSolved.setBackgroundColor(BLUE);
    IS_BLUE = true;
    IS_RED  = false; 

    }

 }
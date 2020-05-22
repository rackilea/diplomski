infoButton.setOnClickListener(new View.OnClickListener() 
 {   
     @Override
     public void onClick(View v)
     {
           Intent i = new Intent(v.getContext(), NextActivityName.class);
           startActivity(i);
     }  
});
Button btnA = (Button) findViewById(R.id.button1);     
btnA.setOnClickListener(new View.OnClickListener() {          
    public void onClick(View v) {             
        // TODO Auto-generated method stub             
        startActivity(new Intent ("com.emods.app1.BUTTONA"));      
    }         
});   
Button btnB = (Button) findViewById(R.id.button2);     
btnB.setOnClickListener(new View.OnClickListener() {          
    public void onClick(View v) {             
        startActivity(new Intent ("com.emods.app1.BUTTONB"));         
    }      
});
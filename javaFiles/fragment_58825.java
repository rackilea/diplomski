EditText input;
@Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.main);


        input = new EditText(this); 

        AlertDialog alertDialog = new AlertDialog.Builder(this).create(); 
        alertDialog.setTitle("Title"); 
        alertDialog.setMessage("Message"); 
        alertDialog.setView(input, 10, 0, 10, 0); // 10 spacing, left and right 

        alertDialog.show(); 

        input.setText("Raja");
        setText("Hindustani");

    }

    public void setText(String url) { 
        input.setText("http://xxxx/" + url); 
        input.invalidate(); 
        input.selectAll(); 
    }
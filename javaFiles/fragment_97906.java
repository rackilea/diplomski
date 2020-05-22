bt.setOnClickListener(new View.OnClickListener() 
        { 
            public void onClick(View v) 
            {
                String ed=edText.getText().toString(); 
                int i = 0;
                try{
                  i =Integer.parseInt(ed);
                 //setting value here
                 text.setText(String.valueof(i));
                 //or you can do like this
                 // text.setText(i+"");
                }catch(NumberFormatException ex){
                  text.setText("Value at TextView is not a valid integer");
                }
            }
        });
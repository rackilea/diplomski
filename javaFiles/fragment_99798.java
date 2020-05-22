add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         try{
        Value1 = Integer.parseInt(num1.getText().toString());
        Value2 = Integer.parseInt(num2.getText().toString());
        result = Value1 + Value2;
            result = Value1 + Value2;

            ans.setText(""+result);
        }
     catch(Exception e)
     {
           Log.e("Exc",e.toString());      
     }


        }

    });
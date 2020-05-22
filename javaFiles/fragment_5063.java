btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


       if(!etNumber.getText.toString().equals("")) {           
         int guessValue =  Integer.parseInt(etNumber.getText().toString());

                String message;

                if(guessValue > randomNumber){
                    message = "Lower !";
                    etNumber.setText("");
                }
                else if (guessValue < randomNumber){
                    message = "Higher !";
                    etNumber.setText("");
                }
                else{
                    message = "You got it right. GG ";
                    etNumber.setText("");
                    generateRandomNos();
                }


        Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
            }
         } else {
           Toast.makeText(MainActivity.this,"EditText Is empty",Toast.LENGTH_SHORT).show();
         }
   });
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // textView.setText("Hello "+name+", Welcome to Android. ");
             String name = editText.getText().toString();
                if(TextUtils.isEmpty(name))
                    Toast.makeText(MainActivity.this, "Edit Text is Empty", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Edit Text is not Empty", Toast.LENGTH_LONG).show();
            }
        });
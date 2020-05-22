public void onClick(View v) {
            if (_text.getText().toString().equals(""))
                Toast.makeText(getApplicationContext(), "Empty BOX", 5000).show();
            else
                Toast.makeText(getApplicationContext(), _text.getText().toString(), 5000).show();

        }
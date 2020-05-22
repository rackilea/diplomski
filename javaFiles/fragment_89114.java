displayText.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
　　　　　　displayContents = display.getText().toString();
            displayTwo.setText(displayContents);

        }
    });
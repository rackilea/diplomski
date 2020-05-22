imageView.setOnClickListener(new View.OnClickListener() { 
            @Override 
            public void onClick(View v) {
                startActivity(new Intent(MyFirstActivity.this, MySecondActivity.class));
            } 
});
button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText("xyz");   // text changed to xyz
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setText("abc");   //text changed to abc after 1 second.
                    }
                },1000);
            }
        });
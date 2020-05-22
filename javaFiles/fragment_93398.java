iimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(currentactivity, youractivity.class);
                intent.putExtra("url", your_url );
                startActivity(intent);
                finish();
            }
        });
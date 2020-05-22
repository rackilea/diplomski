Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextLayout = new Intent(Screen1.this, Screen2.class);
                nextLayout.putExtra("position", value);
                startActivity(nextLayout);
            }
        });
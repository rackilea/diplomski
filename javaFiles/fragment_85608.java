ImageView imageView = findViewById(R.id.image_view_icon);
imageView.setImageResource(R.drawable.play_button);
imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Button Pushed");
                }
            });
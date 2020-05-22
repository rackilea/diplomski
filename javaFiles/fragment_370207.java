buttons = new ImageButton[30];

    for(int i=0; i<buttons.length; i++) {
        {
            buttons[i] = (ImageButton) findViewById(getResources().getIdentifier("imageButton" + (i + 1), "id", this.getPackageName()));
            buttons[i].setTag(i);

            buttons[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    Intent myIntent = new Intent(HomeActivity.this, KlikNaDugme.class)
                    myIntent.putExtra("vrijednost", Integer.parseInt(view.getTag().toString()));
                    startActivity(myIntent);
                }
            });
        }
    }
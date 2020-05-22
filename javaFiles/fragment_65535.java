ValueEventListener eventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            ViewGroup linearLayout = findViewById(R.id.mapLayout);

            if(linearLayout.getChildCount() > 0)
                linearLayout.removeAllViews();

            for(DataSnapshot ds : dataSnapshot.getChildren()) {

                MapModel shiftMap = ds.getValue(MapModel.class);

                View cell = new View(MainActivity.this);

                GradientDrawable shape = new GradientDrawable();

                shape.setShape(GradientDrawable.RECTANGLE);

                //shape.setColor(Color.rgb(33,150,243));

                if (shiftMap.getOra00() == 1)
                {
                    shape.setColor(Color.rgb(33,150,243));
                }
                else if (shiftMap.getOra00() ==0.5)
                {
                    shape.setColor(Color.rgb(179,229,252));
                }
                else if (shiftMap.getOra00() ==0)
                {
                    shape.setColor(Color.rgb(255,255,255));
                }

                shape.setStroke(3, Color.rgb(255,255,255));

                shape.setCornerRadius(5);

                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(70, 50);

                lp.setMargins(1, 1, 1, 1);

                cell.setLayoutParams(lp);

                cell.setBackground(shape);

                linearLayout.addView(cell);
                Log.i("Operator",  shiftMap.getOperator() + " | " + shiftMap.getOra00() + " | " + shiftMap.getOra01());
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {}
    };
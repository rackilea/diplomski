date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View parent = (View) v.getParent();
                parent.performClick();
            }
        });
        total.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                View parent = (View) v.getParent();
                parent.performClick();
            }
        });
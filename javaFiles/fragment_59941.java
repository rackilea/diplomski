Button btn1 = (Button) row.findViewById(R.id.btn1);
Button btn2 = (Button) row.findViewById(R.id.btn2);

btn1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getContext(), second.class);
                getContext().startActivity(i);
            }
       });

btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getContext(), third.class);
                getContext().startActivity(i);
            }
       });
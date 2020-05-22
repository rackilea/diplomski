ArrayList<Integer> total =  new ArrayList();

int totalCount = 0;


        button10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                total.add(10);
            }
        });

        button20.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                total.add(20);
            }
        });

        button50.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                total.add(50);
            }
        });

        button100.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                total.add(100);
            }
        });

        button500.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                total.add(500);
            }
        });

        button1000.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                total.add(1000);
            }
        });

        submitButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i = 0; i < total.size();i++){
                    totalCount = totalCount + total.get(i); //total value or Output
                }
            }
        });
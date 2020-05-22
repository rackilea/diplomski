buttonMenuOption = findViewById(R.id.buttonOption);
 final Button[] buttonsOption = new Button[nbObjects];

buttonMenuOption.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        setContentView(R.layout.graph_option);
         buttonsOption[0] = findViewById(R.id.buttonOption0);//change here
         buttonsOption[1] = findViewById(R.id.buttonOption1);// change here
            for (int i = 0; i < nbObjects; i++) {
                final int j = i;
                    buttonsOption[i].setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            //Do stuff
                          }
                    });
             }
     });
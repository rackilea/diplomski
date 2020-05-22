Button solve = (Button)findViewById(R.id.getfinbutton);
            solve.setOnClickListener(new OnClickListener() {

                public void onClick(View v) {
                   double q1, q2, ex;
         EditText etq1, etq2, eteg;
         etq1 = (EditText)findViewById(R.id.editText1);
            try{
                q1 = Double.parseDouble(etq1.getText().toString());
            } catch (NumberFormatException e) {
                q1=0;
            }
         etq2 = (EditText)findViewById(R.id.editText2);
            try{
                q2 = Double.parseDouble(etq2.getText().toString());
            } catch (NumberFormatException e){
                q2 = 0;
            }
         eteg = (EditText)findViewById(R.id.editText3);
         try{
             ex = Double.parseDouble(eteg.getText().toString());
         } catch (NumberFormatException e){
             ex = 0;
         }
        fin = 0.4*q1+0.4*q2+0.2*ex;
            if(fin == (int)fin){
                System.out.println((int)fin);
            }
            else{
                fin = 0.01*((int)(fin*100));
                System.out.println(fin);
            } 
                    TextView tvfin= TextView)findViewById(R.id.tvfinalgrade);
                         tvfin.setText(fin+"");
                }
            });
//clickhandler
        calc.setOnClickListener(new OnClickListener() {         
            public void onClick(View v) {
                EditText fv = (EditText) findViewById(R.id.pv_fv);
                EditText pv = (EditText) findViewById(R.id.pv_pv);
                EditText r = (EditText) findViewById(R.id.pv_discountrate);
                EditText n = (EditText) findViewById(R.id.pv_periods);
                EditText t = (EditText) findViewById(R.id.pv_years);
                TextView answer = (TextView) findViewById(R.id.pv_answer);
                int filledfields = 0;

                if (fv.getText().toString().equals("")){
                    filledfields ++;
                }
                if (pv.getText().toString().equals("")) {
                    filledfields ++;
                }
                if (r.getText().toString().equals("")) {
                    filledfields ++;
                }
                if (t.getText().toString().equals("")) {
                    filledfields ++;
                }
                if (n.getText().toString().equals("")) {
                    filledfields ++;
                }

                if (filledfields > 1){
                    Toast errormsg = Toast.makeText(PresentValue.this, "Sorry but you left more than one field empty.", 5000);
                    errormsg.setGravity(Gravity.CENTER, 0, 0);
                    errormsg.show();
                }

                else if (fv.getText().toString().equals("")) {
                    double r1 = Double.parseDouble(r.getText().toString());
                    double n1 = Double.parseDouble(n.getText().toString());
                    double t1 = Double.parseDouble(t.getText().toString());
                    double pv1 = Double.parseDouble(pv.getText().toString());
                    double answer1 = pv1*(Math.pow(1+(r1/n1) ,n1*t1 ));
                    answer1 = (double)(Math.round(answer1*100))/100;

                    answer.setText("The Future Value of the cash flow is: "+answer1);
                }

                else if (pv.getText().toString().equals("")) {
                    double fv1 = Double.parseDouble(fv.getText().toString());
                    double r1 = Double.parseDouble(r.getText().toString());
                    double n1 = Double.parseDouble(n.getText().toString());
                    double t1 = Double.parseDouble(t.getText().toString());
                    double answer1 = fv1/(Math.pow(1+(r1/n1) ,n1*t1 ));
                    answer1 = (double)(Math.round(answer1*100))/100;

                    answer.setText("The Present Value of the cash flow is: "+answer1);                      
                }

                else if (r.getText().toString().equals("")){
                    double fv1 = Double.parseDouble(fv.getText().toString());
                    double pv1 = Double.parseDouble(pv.getText().toString());
                    double n1 = Double.parseDouble(n.getText().toString());
                    double t1 = Double.parseDouble(t.getText().toString());
                    double answer1 = ( (Math.pow(fv1/pv1, 1/(n1*t1) ) ) -1)*n1 ;
                    answer1 = (double)(Math.round(answer1*100))/100;

                    answer.setText("The discount rate / interest rate applied is: "+answer1);
                }

                else if (t.getText().toString().equals("")){
                    double fv1 = Double.parseDouble(fv.getText().toString());
                    double pv1 = Double.parseDouble(pv.getText().toString());
                    double n1 = Double.parseDouble(n.getText().toString());
                    double r1 = Double.parseDouble(r.getText().toString());
                    double answer1 = Math.log(fv1/pv1) / (n1* Math.log(1+(r1/n1) ) ) ;
                    answer1 = (double)(Math.round(answer1*100))/100;

                    answer.setText("The number of years is: "+answer1);
                }

                else if(n.getText().toString().equals("")){
                    Toast errormsg = Toast.makeText(PresentValue.this, "Sorry but Number of Periods cannot be computed.", 5000);
                    errormsg.setGravity(Gravity.CENTER, 0, 0);
                    errormsg.show();
                }

                else {
                    Toast errormsg = Toast.makeText(PresentValue.this, "You either left too many fields empty or filled all of them.", 5000);
                    errormsg.setGravity(Gravity.CENTER, 0, 0);
                    errormsg.show();
                }

            }           
        });
        //clickhandler end
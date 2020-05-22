TextWatcher gradeWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
            if (grade.getText().toString().equals("A+"))
                {
                    points.setText("4.00");
                }
                else if (grade.getText().toString().equals("A"))
                {
                    points.setText("3.75");
                }
                else if (grade.getText().toString().equals("A-"))
                {
                    points.setText("3.50");
                }
                else if (grade.getText().toString().equals("B+"))
                {
                    points.setText("3.25");
                }
                else if (grade.getText().toString().equals("B"))
                {
                    points.setText("3.00");
                }
                else if (grade.getText().toString().equals("B-"))
                {
                    points.setText("2.75");
                }
                else if (grade.getText().toString().equals("C+"))
                {
                    points.setText("2.50");
                }
                else if (grade.getText().toString().equals("C"))
                {
                    points.setText("2.25");
                }
                else if (grade.getText().toString().equals("D"))
                {
                    points.setText("2.00");
                }
                else if (grade.getText().toString().equals("F"))
                {
                    points.setText("0.0");
                }
                else
                    points.setText(null);

            }
        };

TextWatcher pointWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {
            if (points.getText().toString().matches("[4]|[4]\\.[0]{0,2}"))
                {
                    grade.setText("A+");
                }
                else if (points.getText().toString().matches("[3]\\.[7][5]{1}"))
                {
                    grade.setText("A");
                }
                else if (points.getText().toString().matches("[3]\\.[5][0]{0,1}"))
                {
                    grade.setText("A-");
                }
                else if (points.getText().toString().matches("[3]\\.[2][5]{1}"))
                {
                    grade.setText("B+");
                }
                else if (points.getText().toString().matches("[3]|[3]\\.[0]{0,2}"))
                {
                    grade.setText("B");
                }
                else if (points.getText().toString().matches("[2]\\.[7][5]{1}"))
                {
                    grade.setText("B-");
                }
                else if (points.getText().toString().matches("[2]\\.[5][0]{0,1}"))
                {
                    grade.setText("C+");
                }
                else if (points.getText().toString().matches("[2]\\.[2][5]{1}"))
                {
                    grade.setText("C");
                }
                else if (points.getText().toString().matches("[2]|[2]\\.[0]{0,2}"))
                {
                    grade.setText("D");
                }
                else if (points.getText().toString().matches("[0]|[0]\\.[0]{0,2}"))
                {
                    grade.setText("F");
                }
                else
                    grade.setText(null);

            }
        };
 /*---------- SET FOCUS LISTENERS ON EDIT TEXT--------------------------*/
    public void setFocus(EditText editText){
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    if (v.getId() == grade.getId()) {     
                        grade.addTextChangedListener(gradeWatcher);
                        points.removeTextChangedListener(pointWatcher);
                    } else if (v.getId() == points.getId()) {
                        points.addTextChangedListener(pointWatcher);    
                        grade.removeTextChangedListener(gradeWatcher);

                    }  
                }
            }
        });
    }
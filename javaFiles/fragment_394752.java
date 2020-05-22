String[] speedArr = getResources().getStringArray(R.array.arraySpeed);

    speed.setAdapter(adapter);
            speed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                     //Do your checks here, and set the next spinner, or reset the previous one.

                 //This automatically gets your selected value, so no need doing an if else check here again
                 String selectedValue = speedArr[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub

                }
            });
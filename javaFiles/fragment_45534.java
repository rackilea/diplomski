String[] machineCodes = getResources().getStringArray(R.array.machineCodes);
      String[] manCodes = getResources().getStringArray(R.array.manCodes);

  //set manCodes to spinner and spinner style

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> a, View v, int which, long id) {
                                    String machineCode = machineCodes[which];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                            }
        });
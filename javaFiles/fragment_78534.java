Static Double selectedDouble;

spinner.setOnItemSelectedListener(myListener);
AdapterView.OnItemSelectedListener myListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                selectedDouble = Double.parseDouble(item);
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
            adapterView.setSelection(0);
            selectedDouble = Double.parseDouble("Some Default Value");

        }
    };

btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
             DoubleArray.add(selectedDouble);
        }

        });
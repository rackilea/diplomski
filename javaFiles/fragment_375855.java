spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
            String id= yourIdArray.get(pos);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    });
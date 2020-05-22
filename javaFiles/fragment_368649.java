spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int myPosition, long myID) {

            String country = spinner.getSelectedItem().toString();
            switch (country){
                case "Delhi":
               //do something
                    break;
                case "Hongkong":
              //do something
                    break;
             // etc,etc,etc
            }
        }
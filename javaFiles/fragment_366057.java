public boolean validate(View view) {
       try {
           if (validate_name() && validate_price() && validate_supplier() && validate_supplier_no()) {
               Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
               return true;
           }
       }
       catch (NumberFormatException e){
           Toast.makeText(getApplicationContext(), "Not Success!", Toast.LENGTH_SHORT).show();
       }
       return false;
    }
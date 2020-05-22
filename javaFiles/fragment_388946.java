@Override
    public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
        if(isChecked){
            //get the id of the checked button for later reference
            int id = cb.getId();

            /*
            * do what you want here based on the id you got
            */

            //uncheck the other RadioButtons
            rb_1.setChecked(id == R.id.rb_1);
            rb_2.setChecked(id == R.id.rb_2);
            rb_3.setChecked(id == R.id.rb_3);

        }
    }
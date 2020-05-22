public void onClick(View arg0) {
     switch (arg0.getId())
      {
         case R.id.editbutton: //updated
            Intent addEditContact =
               new Intent(this, AddEditCountry.class);

            addEditContact.putExtra(CountryList.ROW_ID, rowID);
            addEditContact.putExtra("name", nameTv.getText());
            addEditContact.putExtra("cap", capTv.getText());
            addEditContact.putExtra("code", codeTv.getText());
            addEditContact.putExtra("newb", newEt.getText());

                startActivity(addEditContact); 
                break;

             case R.id.deletebutton: //updated
                deleteContact();
                break;

    }
    }
}
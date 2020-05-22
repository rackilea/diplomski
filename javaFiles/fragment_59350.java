for (int i=0;i<btnEditId.length;i++) 
{
    final int counter=i;
    int button=btnEditId[i];
    findViewById(button).setOnClickListener(new OnClickListener() 
    {

        @Override
        public void onClick(View v) 
        {

            // HERE v refers to button itself on which you clicked, 
            // you need to update get edit text so
            // based on ith position accessing the same edit as the button correspond too
            EditText edt=etColorId[counter];
            edt.setEnabled(true);
            edt.requestFocus();
            // and you are DONE!!!
        }
    });
}
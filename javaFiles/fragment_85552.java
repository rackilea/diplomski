btnOK.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //new item
            final Item newItem = new Item();

            //Set its variables to match the users entries on the form
            newItem.setTitle(editTitle.getText().toString());
            newItem.setDescription(editDescription.getText().toString());
            newItem.setTrue(isTrue);

            FragmentManager manager = getActivity().getSupportFragmentManager();

            ListItems fragment = (ListItems)manager.findFragmentByTag("LISTITEMS");

            if(fragment != null){
               fragment.createNewItem(newItem);
            }            

            dismiss();
        }
    });
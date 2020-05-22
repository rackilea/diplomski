// Set the save button to check the required fields, save the contact and finish
        saveButton.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
            if (TextUtils.isEmpty(mLastName.getText().toString()) ||
                    TextUtils.isEmpty(mFirstName.getText().toString())) {
              makeToast();
            } else {  
                if (getActivity().findViewById(R.id.item_detail_container) != null){
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStackImmediate();
                }
                else{getActivity().finish();}
           }
          }
        });

        // Set the delete button to delete the contact and close the fragment
    deleteButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            // Delete the contactUri created from an ID passed in from contactActivity
            getActivity().getContentResolver().delete(contactUri, null, null);

                if (getActivity().findViewById(R.id.item_detail_container) != null){
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStackImmediate();
                }
                else{getActivity().finish();}
        }
      });  
    return aView;
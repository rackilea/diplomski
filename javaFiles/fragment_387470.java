private void displayValues(View view, int imageButtonID) {
    ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton);
    imageButton.setImageResource(imageButtonID);
    imageButtonnew.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //Create your intent
            //Replace "NextActivity" with your Activity name.
            Intent intent = new Intent(getActivity(), NextActivity.class);
            //This will launch your new Activity
            getActivity().startActivity(intent);
        }
    });

}
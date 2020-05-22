private void displayValues(View view, final int imageButtonID) {
    ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton);
    imageButton.setImageResource(imageButtonID);
    imageButtonnew.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;
            switch(imageButtonID){
                default:
                case R.drawable.1:
                    //Create your intent
                    //Replace "NextActivity1" with your Activity name.
                    intent = new Intent(getActivity(), NextActivity1.class);
                    break;
                case R.drawable.2:
                    //Replace "NextActivity2" with your Activity name.
                    intent = new Intent(getActivity(), NextActivity2.class);
                    break;
                case R.drawable.3:
                    //Replace "NextActivity3" with your Activity name.
                    intent = new Intent(getActivity(), NextActivity3.class);
                    break;
            }
            //This will launch your new Activity
            getActivity().startActivity(intent);
        }
    });

}
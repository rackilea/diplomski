Button imgbtn = (Button) view.findViewById(R.id.editCarProfileButton);
    imgbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(getActivity(),ReserveActivity.class));
        }
    });
awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
 @Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    awesomeValidation.addValidation(getActivity(),R.id.edtxtfullname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
    btnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (awesomeValidation.validate())
            {
                Toast.makeText(getActivity(), "Validation Successfull", Toast.LENGTH_LONG).show();
            }
        }
    });
}
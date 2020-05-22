if(isUsernameValid)
    {
        //Toast.makeText(getActivity(),"VALID FORM!!",Toast.LENGTH_LONG).show();
        ((SignUpPage)getActivity()).getValues().fullname=txtfullname.getText().toString().trim();
        ((SignUpPage)getActivity()).getValues().dob=txtdob.getText().toString().trim();


        int id=radiogender.getCheckedRadioButtonId();
        RadioButton rb=(RadioButton) view.findViewById(id);
        String gender=rb.getText().toString();
        ((SignUpPage)getActivity()).getValues().gender=gender;


        int id1=radiomarital.getCheckedRadioButtonId();
        RadioButton rb1=(RadioButton) view.findViewById(id1);
        String marital_status=rb1.getText().toString();
        ((SignUpPage)getActivity()).getValues().marital_status=marital_status;



        ((SignUpPage)getActivity()).getValues().occupation=txtoccupation.getText().toString().trim();
        ((SignUpPage)getActivity()).getValues().username=txtusername.getText().toString().trim();
        ((SignUpPage)getActivity()).getValues().password=txtpassword.getText().toString().trim();



        ((SignUpPage)getActivity()).selectFragment(1);


    }
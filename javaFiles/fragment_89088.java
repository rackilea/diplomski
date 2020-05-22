signupButon.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        if(validate()) {
            try {
                //new task every click
                Signup newSignup = new Signup(signup);
                //here start AsyncTask
                newSignup.execute(name, email, password).get();
            } catch (Exception e) {
                Toast.makeText(ERROR);
            }
        }
    }
});
btnlog.setOnClickListener (new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String u = usernameField.getText().toString();
            String p = passwordField.getText().toString();
            new loginPost().execute(u,p);
        }
});
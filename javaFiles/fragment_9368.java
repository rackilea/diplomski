private void userLogin(final String username, final String password,final String item){
...
 @Override
        protected String doInBackground(String... params) {
            HashMap<String,String> data = new HashMap<>();
            data.put("username",params[0]);
            data.put("password",params[1]);
            data.put("approver",params[2]);//adding item value
            ..
        }
    }
}
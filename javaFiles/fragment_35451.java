public void onResume(){
    super.onResume();
    getString(new VolleyCallback(){
        @Override
        public void onSuccess(String result){
            System.out.println(result); // returns the value of lastInsertId
        }
    });
}
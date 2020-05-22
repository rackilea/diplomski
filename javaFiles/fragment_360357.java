public void sendMessage(View view){
       String[] text = {"Test 1","Test 2","Test 3"};
        String title = "Test Title";
        DialogFragment fragment = new DialogTest();
        Bundle args = new Bundle();
        args.putString("title_question",title);
        args.putStringArray("choices",text);
        fragment.setArguments(args);
        fragment.show(getSupportFragmentManager(),"testtest123");
        Log.d("tag","Executed after dialog");
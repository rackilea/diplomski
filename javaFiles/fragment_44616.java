if(intent.getExtras() != null && !Textutils(intent.getStringExtra(MainActivity.EXTRA_MESSAGE))){
            String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            textView.setTextSize(40);
            textView.setText(message);          
        }else{
            textView.setTextSize(40);
            textView.setText(R.string.hello_world);
        }
private void startThread(int i){
        if (i<length){

            handler.postDelayed(new TaskScreenshot(i), 250);
            handler.postDelayed(new TaskNoise(), 750);
            handler.postDelayed(new TaskEditText(), 1000);

            myEditText.setOnKeyListener(new View.OnKeyListener(){
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if((keyCode == KeyEvent.KEYCODE_ENTER)) {
                        if(myEditText.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(), "Inserire un numero da 1 a 9", Toast.LENGTH_SHORT).show();
                            return false;
                        } else if (Integer.parseInt(myEditText.getText().toString()) >= 1 &&
                                Integer.parseInt(myEditText.getText().toString()) <= 9){
                            System.out.println(i);
                            i++;
                            startThread(i);
                        }
                    }
                    return false;
                }
            });

        }
        return false;
}
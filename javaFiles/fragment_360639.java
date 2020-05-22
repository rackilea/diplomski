...extends Activity {

   ...
   minusOne.setOnClickListener(new MyClickListener());
   ...

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            counter -= 1;
            counterDisplay.setText(String.valueOf(counter));
        }
    }

    ...
}
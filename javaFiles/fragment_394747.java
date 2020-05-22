calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                if(!TextUtils.isEmpty(alt.getText().toString())){
                altValue = Float.valueOf(alt.getText().toString());
                 if (altValue > 10000 || altValue < -400) {
                    Toast.makeText(getApplicationContext(), "-400 <= Altitude <= 10000 m", Toast.LENGTH_LONG).show();
                }else{

                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }
}
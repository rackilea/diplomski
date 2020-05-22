public void onClickOnColor(View view){

            switch(view.getId()) {
                case R.id.red_circle:
                    Toast.makeText(LoginActivity.this,"Red",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.yellow_circle:
                    Toast.makeText(LoginActivity.this,"Yellow",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.blue_circle:
                    Toast.makeText(LoginActivity.this,"Blue",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.orange_circle:
                    Toast.makeText(LoginActivity.this,"Orange",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.green_circle:
                    Toast.makeText(LoginActivity.this,"Green",Toast.LENGTH_SHORT).show();
                    break;

            }
    }
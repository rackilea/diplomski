edtTitle = (AutoCompleteTextView) findViewById(R.id.edtTitle);
        edtTitle.setOnKeyListener(new OnKeyListener() {

            @Override
            public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
                // TODO Auto-generated method stub

                Toast.makeText(Current_Activity.this, arg1+"",
                Toast.LENGTH_LONG).show();
                // return true; - if consumed
                return false;
            }
        });
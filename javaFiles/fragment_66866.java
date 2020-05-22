try{
                iol.setOnClickListener(new View.OnClickListener() {


                        @Override
                        public void onClick(View v) {
                            // TODO Auto-generated method stub
                           Intent iolIntent=new Intent(FullscreenActivity.this,Selection.class);
                startActivity(iolIntent);
                        }
                });
            }
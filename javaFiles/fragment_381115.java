protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_search_ride);

                etDate=(EditText) findViewById(R.id.etDate);
                TextView tFrom=(TextView) findViewById(R.id.tFrom);
                TextView tTo=(TextView) findViewById(R.id.tTo);
                etFrom=(EditText) findViewById(R.id.etFrom);
                etTo=(EditText) findViewById(R.id.etTo);
                Button bSearch=(Button) findViewById(R.id.bSearch);
                ImageView iplussign=(ImageView) findViewById(R.id.iplussign);
                ImageView iminussign=(ImageView) findViewById(R.id.iminussign);
                final TextView tNumber=(TextView) findViewById(R.id.tNumber);

                tNumber.setText(String.valueOf(p));
                iplussign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(p<=9) {
                            p++;
                            tNumber.setText(String.valueOf(p));
                        }
                    }
                });

                iminussign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(p>=2) {
                            p--;
                            tNumber.setText(String.valueOf(p));
                        }
                    }
                });

                etFrom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent ListFrom = new Intent(SearchRide.this,ListFrom.class);
                        startActivityForResult(ListFrom,0);
                    }
                });

                etTo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent ToList = new Intent(SearchRide.this,ListTo.class);
                        startActivityForResult(ToList,1);
                    }
                });

                etDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog dialog= new DatePickerDialog(SearchRide.this,R.style.MyDatePickerStyle,listener,calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR));
                        dialog.getDatePicker().setMinDate(calendar.getTimeInMillis());
                        dialog.show();
                    }
                });
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == 0) {
                    if(resultCode == Activity.RESULT_OK){
                        etFrom.setText(data.getStringExtra("From"));
                    }
                } else if (requestCode == 1) {
                    if(resultCode == Activity.RESULT_OK){
                        etTo.setText(data.getStringExtra("To"));
                    }

                }}
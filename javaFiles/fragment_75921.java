calendarImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(PrivacyPolicyActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {


//                                SimpleDateFormat dateandmonth = new SimpleDateFormat("dd-MMM");


                                int cyear = datePicker.getYear();
                                int cmonth =datePicker .getMonth();
                                int cday = datePicker.getDayOfMonth();

                                Calendar cld  = Calendar.getInstance();
                                cld.set(cyear, cmonth, cday);
                                SimpleDateFormat format = new SimpleDateFormat("dd-MMM");
                                String strDate = format.format(cld.getTime());
                                todayDate.setText(strDate);

                                SimpleDateFormat dayfmt = new SimpleDateFormat("EEEE");
                                String dayselected = dayfmt.format(cld.getTime());
                                todayDay.setText(dayselected);


                                cld.add(Calendar.DATE, 1);

                                SimpleDateFormat day_fmt = new SimpleDateFormat("EEEE");
                                String tom_day = day_fmt.format(cld.getTime());
                                tommorrowDay.setText(tom_day);


                            }
                        },year,month,dayOfMonth);

                datePickerDialog.show();
            }





        });
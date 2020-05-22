public void Load(String RegNumber, String Semester , String Year){



            final String url = Uri.parse("http://10.0.2.2:84/COOPERP/Mobile/Default.aspx").buildUpon()
                    .appendQueryParameter("DataFormat", "StudentsResults")
                    .appendQueryParameter("reg", RegNumber)
                    .appendQueryParameter("StYr", Year)
                    .appendQueryParameter("sem", Semester)
                    .build().toString();


            final ProgressDialog pd;
            pd = new ProgressDialog(ResultsActivity.this);
            pd.setMessage("Loading....");
            pd.setCancelable(false);
            pd.show();


            Ion.with(getBaseContext())
                    .load(url)
                    .progressDialog(pd)
                    .as(new TypeToken<List<StudentsResults>>() {
                    })
                    .setCallback(new FutureCallback<List<StudentsResults>>() {

                        @Override
                        public void onCompleted(Exception e, List<StudentsResults> itemList) {
                            final StudentsResultsAdapter adapter = new StudentsResultsAdapter(itemList, getApplicationContext());

                            try {

                                if (itemList != null) {

                                    String Gradept = itemList.get(0).getGradept().toString();
                                    String Gpa = itemList.get(0).getGpa().toString();
                                    gpa.setText(Gpa);
                                    gradept.setText(Gradept);
                                    rv.setAdapter(adapter);
                                    rv.hasFixedSize();
                                    rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                                } else {
                                    gpa.setText(null);
                                    gradept.setText(null);
                                    rv.setAdapter(null);
                                    rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                                    Toast.makeText(getApplicationContext(), "No Results found!", Toast.LENGTH_SHORT).show();
                                }

                                pd.dismiss();

                            }
                            catch (Exception ex){
                                Toast.makeText(getApplicationContext(), "No Results found!", Toast.LENGTH_SHORT).show();
                                pd.dismiss();
                            }
                        }
                    });




    }
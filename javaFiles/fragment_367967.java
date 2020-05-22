Submit = (Button) findViewById(R.id.btnSubmit); //Instantiates the button in the onCreate method 
        Submit.setOnClickListener(new OnClickListener(){  //Called when the user clicks on the Submit button

            @Override
            public void onClick(View v) {
            // In this case the text to be written is the selected text in a radio button from radioGroup
                int Selection = AttendanceGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id 
                RadioButton radiobutton = (RadioButton) findViewById(Selection); 

                    // write on SD card file data in the text box
                    try {

                        //gets the current date since this is an attendance app.
                        Calendar c = Calendar.getInstance();
                        //Formats the date a desired
                        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy");
                        String getDate = date.format(c.getTime());

                        //writes the text to the file named attendance.txt which is created in the phone.
                        File myFile = new File("/sdcard/Albanapp/Attendance.txt");
                        FileWriter fOut = new FileWriter(myFile, true);
                        fOut.append(getDate + "\t" + getSelectedName.getSelectedItem().toString() + "\t" + radiobutton.getText().toString() + "\n");
                        fOut.flush();
                        fOut.close();

                        //Returns a statment to the user showing if the editing of the attendance.txt file was successful or not.  
                        Toast.makeText(getBaseContext(),"Status Saved", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getBaseContext(), "Attendance cannot be saved",
                                Toast.LENGTH_SHORT).show();
                    }
            }
        });
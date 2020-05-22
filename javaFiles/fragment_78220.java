myCB.setOnCheckedChangeListener(new OnCheckedChangeListener(){

                public void onCheckedChanged(CompoundButton thisCheckBox,
                        boolean isChecked) {
                    // TODO Auto-generated method stub

                    myCur.moveToPosition(thisCheckBox.getId());

                    if(isChecked)
                    {
                        Toast.makeText(myContext,"Attendance deducted to " + ((myCur.getFloat(2)) - 2) + "%", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(myContext,"Attendance reverting to " + (myCur.getFloat(2)) + "%", Toast.LENGTH_SHORT).show();
                    }

                }
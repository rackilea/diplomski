for (int i = 0; i <list.getCount() ; i++) {
                     View vListSortOrder;
                            vListSortOrder=list.getChildAt(i);     
                            try{
                                TextView textval= (TextView)vListSortOrder.findViewById(R.id.TextView01);
                                CheckBox ckc=(CheckBox)vListSortOrder.findViewById(R.id.chkbox1);
                                EditText edit=(EditText)vListSortOrder.findViewById(R.id.txtbox);
                                if (ckc.isChecked()){
                                      edit.getText().toString();
                                      String temp1 = textval.getText().toString();
                                      Toast.makeText(getApplicationContext(), "fuck"+textval.getText().toString(), Toast.LENGTH_LONG).show();
                                      val.add(temp1);
                                }   
                            }catch (Exception e) {
                                // TODO: handle exception
                            }
                    }
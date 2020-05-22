public void show(View view)
                    {
                        cnt++;
                        if(cnt<26)
                        {

                             for(int i = 0; i<butt.length; i++){

                                 final Button b = butt[i];

                                 b.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v) {

                                         b.setText("Some number");
                                     }
                                 });
                            }
                        }
                    }
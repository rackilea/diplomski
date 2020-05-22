tv1.setLayoutParams(lparams);
                    tv1.setTag(i);
                    tv1.setId(i);
                    tv1.setTextSize(30);
                    tv1.setPadding(50, 0 ,0,0);

                    tv1.setText(notification);                    

                   tv1.setBackgroundColor(Color.GRAY);

                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            v.setBackgroundColor(Color.LTGRAY);
                        }
                    });

                    tv[i] = tv1;
                    linearLayout.addView(tv[i]);
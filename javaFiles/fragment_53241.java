final ImageButton imageButton=(ImageButton) findViewById(R.id.imageView);
                    imageButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            imageButton.setVisibility(View.INVISIBLE);
                            pic1 = (ImageView) findViewById(R.id.imageView2);
                            pic2 = (ImageView) findViewById(R.id.imageView3);
                            pic3 = (ImageView) findViewById(R.id.imageView4);
                            pic4 = (ImageView) findViewById(R.id.imageView5);

                            ArrayList<Integer> imageIds= new ArrayList<>(Arrays.asList(1, 2, 3, 4))
                            Collections.shuffle(imageIds);

                            pic1.setImageResource(getResources().getIdentifier("img" + imageIds[0], "drawable", getPackageName()));
                            pic2.setImageResource(getResources().getIdentifier("img" + imageIds[1], "drawable", getPackageName()));
                            pic3.setImageResource(getResources().getIdentifier("img" + imageIds[2], "drawable", getPackageName()));
                            pic4.setImageResource(getResources().getIdentifier("img" + imageIds[3], "drawable", getPackageName()));

                        }
                    });
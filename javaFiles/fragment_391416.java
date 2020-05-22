public void initialize(){
            yellowBar.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if(colorNumber == 0){
                        points ++;
                        score.setText(String.valueOf(points));
                        updateColors();
                    }
                }
            });
            greenBar.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if(colorNumber == 1){
                        points ++;
                        score.setText(String.valueOf(points));
                        updateColors();
                    }
                }
            });
            redBar.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){
                    if(colorNumber == 2){
                        points++;
                        score.setText(String.valueOf(points));
                        updateColors();
                    }
                }
            });

        }
     }

     public void updateColors(){
     colorNum = new Random();
            colorNumber = colorNum.nextInt(2);

            switch (colorNumber){
                case 0: colors.setDisplayedChild(0);
                        break;

                case 1: colors.setDisplayedChild(1);
                        break;

                case 2: colors.setDisplayedChild(2);
                        break;
            }
            colors.setVisibility(View.VISIBLE);
     }
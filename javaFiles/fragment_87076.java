int counter = 0;
    button.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 switch(counter){
                    case 0:
                    //First ImageView
                    counter++;
                    break;
                    case 1:
                    //Second ImageView
                    counter++;
                    break;
                    case 2:
                    //Third ImageView 
                    counter = 0;
                    break;
                }
            }
        });
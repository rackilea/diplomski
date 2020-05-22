@Override
public boolean onCreateOptionsMenu (Menu add){

    this.menu = add ;

    if (cool == 2){

         //Adding our menu to toolbar
         //noir
         getMenuInflater().inflate(R.menu.add, add);
    } else {
       //vert
       getMenuInflater().inflate(R.menu.alreadyadded, add);
    }


    return true;   }
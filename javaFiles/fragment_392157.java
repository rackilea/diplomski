if (id==R.id.Submit){
int counter=0;
    for(int i=0; i<colA.length; i++ ){
        if (((colA[i].getText()==("0"))) || ((colA[i].getText()==("1")))){
          counter++;
        }

    }

  if(counter==colA.length){
           //all have been clicked

        }
else{
  System.out.println("Please enter all values for Column A.");

 }
}
@Override
    public void onItemClick(AdapterView <? > parent, View view, int position, long id) {

       // Here position denotes which row index you clicked.
      //If you clicked first item in ListView then row index will be zero
     // and so on...

       switch (position) {
       case 0:
           //First Item/row clicked
           break;
       case 1:
           //Second Item/row clicked
           break;
       }
   }
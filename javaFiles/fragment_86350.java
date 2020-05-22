int i = 0;

onClick(View v){
   switch(++i){
       case 1:
         view1.setVisibility(View.GONE);
         break;
       case 2:
         view2 setVisibility(View.GONE);
         break;
       case 3:
         view3.setVisibility(View.GONE);
         i = 0;
         break;
      }
    }
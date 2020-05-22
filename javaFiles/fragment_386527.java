if(dyibul.numdigits(le)==3){
       int me= (le/100);
       int ne=  le-me*100;
       char y = (char) (me+65);
       char z = (char) (ne+65);
       String bu=(y+""+z);
       umudo.add(bu);
   }else{
       int me= (le/100);
       int ne=  le-me*100;
       char y = (char) (me+65);
       char z = (char) (ne+65);
       String bu2=(y+""+z);
       umudo.add(bu2);
   }
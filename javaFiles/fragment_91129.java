public void getDate(){
       Date d = new Date();//Put your date here

       SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");//use java.text.SimpleDateformat

       String newFomart = formatter.format(d);
   }
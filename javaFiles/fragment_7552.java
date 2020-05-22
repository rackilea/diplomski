public void ZAP() { 
            if(i < totalElements){

                retval =list.get(i);

                if  (retval==1){                
                check = 1;              
                Centre.setImageResource(R.drawable.flash1);
             ResetTimer.start();        

            }       
            else if (retval==2){

                check = 2;          
                upperRight.setImageResource(R.drawable.flash2);                     
             ResetTimer.start();

            }   
            else if (retval==3){

                check =3;   
                lowerRight.setImageResource(R.drawable.flash3); 
                 ResetTimer.start();    

            }   
            else if (retval==4){

                check = 4;      
                lowerLeft.setImageResource(R.drawable.flash4); 
                 ResetTimer.start();

            }   
            else if (retval==5){

                check=5;
                upperLeft.setImageResource(R.drawable.flash5);  
                 ResetTimer.start();
            }}

            }
    public void Rand() {
            i=0 ;


        Random rand = new Random();
        int rndInt = rand.nextInt(5)+ 1 ;       
        list.add(rndInt);
         totalElements = list.size();
     Log.d("LOOK", Integer.toString(rndInt));
     Log.i("VALUE LIST ", list.toString()+" <<<<LIST HERE"); 
     ZAP();
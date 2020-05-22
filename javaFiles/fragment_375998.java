Random randNumList = new Random(); //do this only once - no need to re-create it you can re-use it

for(int i=0; i<asManyAsYouWantPlusOne; i++){

       randNum = 0; //important! reset here or you will end up with all the same random numbers ...

       while( !(randNum>=15 && randNum<=32)&& !(randNum>=212 && randNum<=229))
       {
         randNum = randNumList.nextInt(251);
       }
      //add to list, or array here ...
       System.out.println(randNum);
     }
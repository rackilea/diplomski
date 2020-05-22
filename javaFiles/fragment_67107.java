Thread threads = new Threads[numberofcards];
for(int i = 1; i < numberofcards; i++ ){ 
   cardArray[i] = new card(i, acc1);
   threads[i] = new Thread(cardArray[i]);
   threads[i].start();
}
for(int i = 1; i < threads.length; i++ ){
   threads[i].join();
}
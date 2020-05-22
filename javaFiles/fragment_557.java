class ThreadPractice implements Runnable{

 @Override   //This annotation denotes that it overrides an abstract method from
             // the Runnable interface.
     public void run(){ // We've promised

      coutingStuff() ; // Calling the synchronized method from the run() method.

         }

      public void synchronized coutingStuff(){// now this is a synchronized method...

              for(int i=0; i<100; i++){// Creating a for loop that counts from 0 to 99...

               System.out.println("this is the "+i+" time that this loop runs");

                // Now, putting the thread to sleep for 1 second:


               try{
                    Thread.sleep(1000);

                     }catch(InterruptedException iex){

                         System.out.println(iex.getMessage());
                      }
               }// End for loop
       }// End public void synchronized coutingStuff(){....


          public static void main(String[] args){

             //Now creating a thread object:

             Runnable rnb = new ThreadPractice();
              Thread count = new Thread(rnb);
                 count.start(); // starts the thread that contains
                                 // the synchronized method.

                }// End main



        }// End of class ThreadPractice
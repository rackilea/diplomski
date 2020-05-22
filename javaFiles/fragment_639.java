class PrimeNumbersTask extends 
         SwingWorker<List<Integer>, Integer> {
     PrimeNumbersTask(JTextArea textArea, int numbersToFind) { 
         //initialize 
     }

     @Override
     public List<Integer> doInBackground() {
         while (! enough && ! isCancelled()) {
                 number = nextPrimeNumber();
                 publish(number);
                 setProgress(100 * numbers.size() / numbersToFind);
             }
         }
         return numbers;
     }

     @Override
     protected void process(List<Integer> chunks) {
         for (int number : chunks) {
             textArea.append(number + "\n");
         }
     }
 }
class PrimeNumbersTask extends SwingWorker<List<Integer>, Integer> {

     PrimeNumbersTask(JTextArea textArea, int numbersToFind) {
         //initialize
     }

     @Override
     public List<Integer> doInBackground() {
         while (! enough && ! isCancelled()) {
                 number = nextPrimeNumber();
                 publish(number); // each computed number is published
                 setProgress(100 * numbers.size() / numbersToFind); // and progress updated
             }
         }
         return numbers;
     }

     @Override
     protected void process(List<Integer> chunks) {
         // in the mean while, we print each published value to a textarea
         for (int number : chunks) {
             textArea.append(number + "\n");
         }
     }
 }
…
BlockingQueue<Integer> answers = new SynchronousQueue();
Thread t = new ReaderThread(answers);
t.start();
for (int i = 0; i < numQuestions; ++i) {
  questions.askQuestion(i);
  System.out.print("Your answer (number): ");
  Integer answer = answers.poll(5, TimeUnit.SECONDS);
  playerIsRight = (answer != null) && questions.checkAnswer(i, answer - 1); 
  …
}
t.interrupt();
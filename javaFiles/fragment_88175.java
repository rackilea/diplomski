...
/* Start the thinkers... */
for (int i = 0; i < N; i++) {
  thinker[i] = new Thinker(i, sem);
  thinker[i].start();
}
/* Wait for them to finish... */
for (int i = 0; i < N; i++) {
  try {
    thinker[i].join();
  } catch(InterruptedException ex) {
    return;
  }
}
...
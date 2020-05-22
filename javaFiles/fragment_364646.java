Phil[] phils = new Phil[N];
Semaphore[] forks = new Semaphore[N];
for (int i = 0; i < N; i++) {
    forks[i] = new Semaphore(1);
    phils[i] = new Phil(i, forks, N);
}
for (Phil phil : phils)  {
    phil.start();
}
for (int i = 0; i < N; i++) {
    phils[i].join();
}
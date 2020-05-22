Thread[] TCreate = new Thread[iThreadSize];
for (int i = 0; i < TCreate.length; i++) {

    TCreate[i] = new Thread(new Runnable() {
        public void run() {
            lst.Add(this.getResult(url));
        }
    });
    TCreate[i].setName("URL"+i);
    TCreate[i].start();
}

for (int j = 0; j < TCreate.length; j++)
    while (TCreate[j].isAlive())
         Thread.sleep(10);
new SecondThreadDemo().run();
new SecondThreadDemo().run();
new Thread(new SecondThreadDemo(), "T3").run();
new Thread(new SecondThreadDemo(), "T2").start();
new SecondThreadDemo().run();
new Thread(new SecondThreadDemo(), "T3").start();
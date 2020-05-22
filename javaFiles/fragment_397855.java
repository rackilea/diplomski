final int length = 10;
final AtomicBoolean flag = new AtomicBoolean();
new Thread(new Runnable() {
    public void run() {
        for (int i=1;i<=length;i++) {
            while(flag.get());
            System.out.print(i+" ");
            flag.set(true);
        }
    }
}).start();

new Thread(new Runnable() {
    public void run() {
        for (char c='a';c<'a'+length;c++) {
            while(!flag.get());
            System.out.print(c+" ");
            flag.set(false);
        }
       System.out.println();
    }
}).start();
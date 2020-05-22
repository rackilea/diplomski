public static void main(String[] args) throws InterruptedException {
    List<String> textList = new ArrayList<>();
    new Thread( () -> {
        synchronized(textList) {
            for(int index=0; ; index++) {
                while(index>=textList.size()) try {
                    textList.wait();
                } catch(InterruptedException ex) { return; }
                final String item = textList.get(index);
                if(item==null) break;
                System.out.println(item);
            }
        }
    }).start();

    for (int i = 0; i < 10; i++) {
        synchronized(textList) {
            textList.add(""+i);
            textList.notify();
        }
        Thread.sleep(100);
    }
    synchronized(textList) {
        textList.add(null);
        textList.notify();
    }
}
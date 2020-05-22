public static void main(String[] args) throws InterruptedException {
    List<String> textList = new ArrayList<>();
    new Thread( () -> {
        int index=0;
        while(true) synchronized(textList) {
            for(; index<textList.size(); index++)
                System.out.println(textList.get(index));
        }
    }).start();

    for (int i = 0; i < 10; i++) {
        synchronized(textList) {
            textList.add(""+i);
        }
        Thread.sleep(100);
    }
}
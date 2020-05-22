private static List<String> taxiidlist = new ArrayList<>();
static int h = 0;

public static void main(String[] args) {

    int id = 0;
    boolean assined = false;
    boolean requested = true;
    taxiidlist.add("One");

    new Thread(new Runnable() {
        @Override
        public void run() {
            while (h <= taxiidlist.size() && assined == false && requested == true) {
                post(new Runnable() {
                    @Override
                    public void run() {
                        client2(id, taxiidlist.get(h));
                        h++;

                        try {
                            Thread.sleep(1500);
                            System.out.println("slept!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });

                break;
            }
        }
    }).start();

}

static void post(Runnable runnable) {
    System.out.println("post!");
    runnable.run();

}

static void client2(int id, String s) {
    System.out.println("client2!");
}
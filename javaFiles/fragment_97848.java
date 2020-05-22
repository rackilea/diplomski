class InventoryInterface1 implements Runnable {

    private Inventory inv;

   public InventoryInterface1(Inventory inv) {
        this.inv = inv;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
        System.out.println(Thread.currentThread().getName() + " updates  inventory");
        inv.incrementInventory(100);         

    }
}



  class InventoryInterface2 implements Runnable {

    private Inventory inv;

    public InventoryInterface2(Inventory inv) {
        this.inv = inv;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
        System.out.println(Thread.currentThread().getName() + " updates inventory");
        inv.incrementInventory(200);
    }
}
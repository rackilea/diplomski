class Inventory {

    private AtomicLong inventory = new AtomicLong();

    public long getInventory() {
        return inventory.longValue();
    }

    public void incrementInventory(long inventory) {
        inventory.addAndGet(inventory);
    }
}
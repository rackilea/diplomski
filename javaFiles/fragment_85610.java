class BoundedArrayList<E> extends ArrayList<E> {
    private int fixedCapacity;

    public BoundedArrayList(int fixedCapacity) {
        super(fixedCapacity);
        this.fixedCapacity = fixedCapacity;
    }

    @Override
    public boolean add(E e) {
        // is it about to cross limit ? removing it in advance
        if(this.size() > fixedCapacity - 1) {
            E element = this.remove(fixedCapacity - 1);
            System.out.println("Removed due to overflow : " + element);
        }
        this.add(0, e);
        return true;
    }

    public static void main(String[] args) {
        BoundedArrayList<Integer> list = new BoundedArrayList<Integer>(5);
        for(int i =0 ; i < 10; i++) {
            list.add(i);
            System.out.println(list);
        }
    }
}
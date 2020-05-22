new LinkedList<Integer>() {
    @Override
    public boolean add(Integer e) {
        if(e == null)
            return false;
        return super.add(e);
    }
};
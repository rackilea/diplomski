public static void main(String[] args) {
    Box b = new Box();
    ArrayList<Pencil> box = b.list;
    for(Iterator<Pencil> it = box.iterator(); it.hasNext();) {
        Pencil p = it.next();
        if ("black".equals(p.getColor())) {
            it.remove();
        }
    }
}
private ArrayList<PietCodel> blockCountHelper(PietCodel codel) {
    ArrayList<PietCodel> accumulator = new ArrayList<>();
    LinkedList<PietCodel> queue = new LinkedList<>();
    queue.add(codel);

    while (!queue.isEmpty()) {
            PietCodel ajac = queue.remove();
            if (ajac != null && codel.equals(ajac.getColor()) .... ) {
                accumulator.add(ajac);
            }
            if ( get(col + 1, row) != null ) {queue.addFirst(get(col + 1, row));}
            if ( get(col , row + 1) != null ) {queue.addFirst(get(col, row + 1));}
            if ( get(col - 1, row) != null ) {queue.addFirst(get(col - 1, row));}
            if ( get(col , row - 1) != null ) {queue.addFirst(get(col, row- 1));}
    }
    return accumulator;
}
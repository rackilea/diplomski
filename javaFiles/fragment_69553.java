boolean containsSamePrice(LinkedList<Bid> list, double price) {
        for (Bid bid : list) {
            if (bid.getBidprice() == price) {
                return true;
            } 
        }
        return false;
    }

LinkedList<Bid> mergeAndSort(LinkedList<Bid> newLinkedList, LinkedList<Bid> oldLinkedList) {
    for (Bid oldBid : oldLinkedList) {
        if (!containsSamePrice(newLinkedList, oldBid.getBidprice())) {
            newLinkedList.add(oldBid);
        }
    }
    Comparator<Bid> comparator = new Comparator<Bid>() {
        @Override
        public int compare(Bid o1, Bid o2) {
            if (o1.getBidprice() < o2.getBidprice())
                return -1;
            if (o2.getBidprice() == o2.getBidprice())
                return 0;
            return 1;
        }
    };
    Collections.sort(newLinkedList, comparator);
    return newLinkedList;
}
for (Iterator<Offer> iterator = offers.iterator(); iterator.hasNext() ;) {
    Offer offer = iterator.next();
    if (offer.isSpecialOffer()) {
        iterator.remove(); // Must remove using the iterator!
        System.out.println(offer.isSpecialOffer() + ".." + offer.getName());
    }
}
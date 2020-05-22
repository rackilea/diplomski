for (int i = offers.size() - 1; i >= 0; i--) {
    Offer offer = offers.get(i);
    if (offer.isSpecialOffer()) {
        offers.remove(i);
        // Use offer, not offers.get(i)
        System.out.println(offer.isSpecialOffer() + ".." + offer.getName());
    }
}
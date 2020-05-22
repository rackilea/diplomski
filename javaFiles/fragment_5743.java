public List<ImageView> getImageViews(List<Card> newCards){
    for (Iterator<ImageView> imageViewIt = allCards.iterator(); imageViewIt.hasNext();) {
        ImageView imageView = imageViewIt.next();
        String imageName = imageView.getId().toLowerCase();
        for (Card card: newCards){
            String cardName = card.getName().toLowerCase();
            if (imageName.equals(cardName)){
                imageViewIt.remove();
                break;
            }
        }
    }
    return allCards;
}
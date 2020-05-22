public List<ImageView> getImageViews(List<Card> newCards){
    allCards.removeIf(view -> 
                       newCards.anyMatch(card -> 
                                card.getName().equalsIgnoreCase(view.getId())
                     );
   return allCards;
}
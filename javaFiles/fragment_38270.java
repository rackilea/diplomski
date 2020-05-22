int points = 0;
for (Card removeCard : testRoll){
    playerHand.removeCard(removeCard);
    points += removeCard.pointValue();
}
player.setScore(points);
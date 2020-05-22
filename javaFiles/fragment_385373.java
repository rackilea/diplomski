if (card1.getSet() > card2.getSet()) {
    return 1;
}
if (card1.getSet() < card2.getSet()) {
    return -1;
};
if (card1.getRarity() < card2.getRarity()) {
    return 1;
}
if (card1.getRarity() > card2.getRarity()) {
    return -1;
}
if (card1.getId() > card2.getId()) {
    return 1;
}
if (card1.getId() < card2.getId()) {
    return -1;
}
return cardType - item.getCardType();  //watch out for overflow!
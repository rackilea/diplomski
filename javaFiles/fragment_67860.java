public boolean checkCards() {
    for(int i = 0; i < cards.size(); i++) {
        if(cards.get(i) != i + 1) {
            return false;
        }
    }
    return true;
}
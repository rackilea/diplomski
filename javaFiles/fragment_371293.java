private void setTotal() {
    handTotal = 0;
    boolean ace = false;
    for (Card c : hand) {
        int value = c.getValue();
        if (value == 1) {
            ace = true;
        }
        handTotal += (value > 10) ? 10 : value;
    }
    if (ace && handTotal < 12) {
        handTotal += 10;
    }
}
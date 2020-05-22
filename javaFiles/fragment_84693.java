for (int i = 0; i < _____; i++) {
    for (int row = 0; row < card.length; row++) {
        while (!valid) {
            tmp = (int) (Math.random() * 15) + _____;
            if (!alreadyUsed.contains(tmp)) {
                valid = true;
                alreadyUsed.add(tmp);
            }
        }
        card[row][_____] = tmp;
        valid = false;
     }
}
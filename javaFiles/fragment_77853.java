squares.stream().forEach(square -> {
    square.addActionListener(e -> {
        if (!pressed) {
            pressed = true;
            fromR = square.rank;
        }
        throw new UnsupportedOperationException("Not supported yet.");
    });
});
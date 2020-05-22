private void generateFullField(final int row, final int column) {
    if (!field.isFilled(field.fieldSize(), field.fieldSize())) {
        while (field.numberOfTriedNumbers(row, column) < field.variantsPerCell()) {
            int candidate = 0;
            do {
                candidate = field.getRandomIndex();
            } while (field.numberHasBeenTried(candidate, row, column));
            if (field.checkNumberField(candidate, row, column)) {
                field.set(candidate, row, column);
                Index nextCell = field.nextCell(row, column);
                if (nextCell.i <= field.fieldSize()
                        && nextCell.j <= field.fieldSize()) {
                    generateFullField(nextCell.i, nextCell.j);
                }
            } else {
                field.tryNumber(candidate, row, column);
            }
        }
        if (!field.isFilled(field.fieldSize(), field.fieldSize())) {
            field.reset(row, column);
        }
    }
}
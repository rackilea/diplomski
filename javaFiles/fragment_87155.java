for (int j = 0; j < 6; j++) {
    final int finalIndex = j + 1;
    instructionPane.get(j).InstBlockAddActionListener((ActionEvent ae) -> {
        InstructionCheckMarkButtonPressed(finalIndex);
    });
}
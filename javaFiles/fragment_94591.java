@Override
public void actionPerformed(ActionEvent e) {
    newData[0] = randomValue();
    for (int i = 0; i < 10; i++) {
        dataset.advanceTime();
        dataset.appendData(newData);
    }
}
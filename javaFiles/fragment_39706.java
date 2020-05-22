int value = 0;
for (int i = 0; i < array.length; i++) {
    if (array[i].isSelected()) {
        value |= (1 << i);
    }
}
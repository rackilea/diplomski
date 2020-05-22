List<Integer> pecasList = new ArrayList<>();
for (int i = 0; i < checkBoxes.length; i++) {
    if (checkBoxes[i].isSelected()) {
        pecasList.add(i+1);
    }
}
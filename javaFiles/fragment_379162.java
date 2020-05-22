String text = "listBoxText";
int indexToFind = -1;
for (int i=0; i<listBox.getItemCount(); i++) {
    if (listBox.getItemText(i).equals(text)) {
        indexToFind = i;
        break;
    }
}
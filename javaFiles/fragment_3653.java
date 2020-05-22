// Note the < here - not <=
for (int i = 0; i < 3; i++) {
   // If you're using the array
   String text = textBoxes[i].getText();

   // or for the list...
   String text = textBoxes.get(i).getText();
}
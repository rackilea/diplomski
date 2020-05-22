String countString = "";

    for (int i = 0; i < 26; i++)
    {
      int n = letterCounts[i];

      if (n == 0) {
        countString = countString + "   ";
      } else if (n < 10) {
        countString = countString + " " + n + " ";
      } else {
        countString = countString + n + " ";
      }
    } 

    this.countLabel.setText(countString);
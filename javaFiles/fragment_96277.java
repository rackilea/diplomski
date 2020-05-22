for (i = 4; i <= 50; i++) {
     for (j = 4; j <= 50; j++) {
        if (number == i * j || (i * j) + 1 == number
              || (i * j) - 2 == number) {
           // rectangularDucts.add(i + " x " + j); //!!
           comboModel.addElement(i + " x " + j); //!!
        }
     }
     if (number == i * j || (i * j) + 1 == number || (i * j) - 2 == number) {
        // rectangularDucts.add(i + " x " + j);
        comboModel.addElement(i + " x " + j); //!!
     }
  }
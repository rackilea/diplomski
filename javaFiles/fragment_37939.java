int i = 0;
    while (i < a.length) {
         a[i] = 1 + (int) (Math.random() * 10);
         myWindow.writeOutLine(a[i]);
         total += a[i];
         i++;
    }
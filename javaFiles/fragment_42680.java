match = false;
for (int ii = 0; ii < randW.length(); ii++) {
    if (guess == randW.charAt(ii)) {
        hiddenW.setCharAt(ii, guess);
        match = true;
    } 
}
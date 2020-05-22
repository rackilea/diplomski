for(int i = 0; getInput.length() > i; i++) {
    if (i != 0 && i % getSpace == 0)
        toInput2 = toInput2 + "_";

    toInput2 = toInput2 + getInput.charAt(i);
}
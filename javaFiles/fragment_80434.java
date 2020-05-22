for (int i = 0; i < len; i++) {
    if ( swapped.hasValue(i) )
        stroke(255, 0, 0);
    else
        stroke(255);
    line(i, height, i, height - lines[i]);
}
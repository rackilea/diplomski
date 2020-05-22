// for each position from the second-last to the second
for(int i = values.length - 2; i >= 1; i--) {
    // if the current value is not null
    if(values[i] != null) {
        // put it in the next position to the right
        values[i+1] = values[i];
    }
}
// now set the first item to 1
values[0] = 1;
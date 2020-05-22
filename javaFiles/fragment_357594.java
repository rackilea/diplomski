String[] out = new String[array.length];
for (int i = 0; i < array.length; i++) {
    if (array[i] == findUp || array[i] == findLo) {
        out[i] = String.valueOf(i);
    } else {
        out[i] = String.valueOf(array[i]);
    }
}
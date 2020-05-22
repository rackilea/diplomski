String[][] converted = new String[a.length][];
for(int index = 0; index < a.length; index++) {
    converted[index] = new String[a[index].length];
    for(int subIndex = 0; subIndex < a[index].length; subIndex++){
        converted[index][subIndex] = Integer.toString(a[index][subIndex]);
    }
}
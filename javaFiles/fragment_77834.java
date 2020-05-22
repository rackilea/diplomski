String[][] tmp = new String[test.length - 1][];
int j = 0;
for (int i = 0; i < test.length; i++) {
    if (i != indexOfItemToRemove) {
        tmp[j++] = test[i];
    }
}
test = tmp;
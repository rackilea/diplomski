int value = 8;
for(int i = 0; i < array.length; i++) {
    if(array[i] < value) {
        break;
    }
}

for(int j = array.length; j > i; j--) {
    a[j] = a[j -1];
}
a[j] = value;
size++;
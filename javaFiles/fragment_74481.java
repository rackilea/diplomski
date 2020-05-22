int count = 1;
int index = 0;

byte current = bytes[index];
while (index < bytes.length - 1) {
    index++;
    if (bytes[index] == current) {
        count++;
    } else {
        integers.add(current);
        frequencies.add(count);
        count = 1;
        current = bytes[index];
    }
}

integers.add(current);
frequencies.add(count);
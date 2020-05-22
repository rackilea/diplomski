CellPhone[] newPhones = new CellPhone[phones.length - 1];
int oldIndex = 0, newIndex = 0;
while (oldIndex < phones.length) {
    if (oldIndex != deleteIndex) { // Skip copying deleted number
        newPhones[newIndex++] = phones[oldIndex];
    }

    oldIndex++;
}
int mini(int array[], int size) {
    if (size == 1) {
        return array[0];
    }
    else {
        return (array[size] < mini(array, size - 1)) ? array[size]: mini(array, size - 1);
    }
}
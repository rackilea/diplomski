public boolean remove(int value) {
    Boolean bool = false;
    for (int i = 0; i < values.length; i++) {
        if (values[i] == value) {
            values[i] = -1; 

            if (values[i] == -1)
                bool = true;
        }
    }
    return bool;
}
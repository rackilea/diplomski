List<E> x = ...;
int j = 0;
for (E ej : x) {
    int iMax = j++;
    int i = 0;
    for (E ei : x) {
        if (i++ >= iMax)
            break;
        someOperation(ei, ej);
    }
}
while (obj.fibonacci(i) <= 4000000) {
    if (obj.fibonacci(i) % 2 == 0) {
        sum += obj.fibonacci(i);
    }
    i++;
}
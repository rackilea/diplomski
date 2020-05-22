Integer num;
    Integer lock;
    Integer num2;

    for (num2 = 1; num2 < Array.size(); num2++) {
        lock = Array.get(num2);

        for (num = num2 - 1; (num >= 0) && (Array.get(num) < lock); num--) {
            Array.set(num + 1, Array.get(num));
        }
        Array.set(num + 1, lock);
    }
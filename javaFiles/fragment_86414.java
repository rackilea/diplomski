boolean unique;
System.out.println();
for (int i = 0; i < 100; i++) {
    unique = true;
    for (int j = i + 1; j < 100; j++) {
        if (a[i] == a[j]) {
            unique = false;
            break;
        }
    }
    if (unique) {
        System.out.println("Doesn't repeat: " + a[i]);
    } else {
        for (int k = i + 1; k < 100; k++) {
            if (a[k] != a[i]) {
                i = k - 1;
                break;
            }
        }
    }
}
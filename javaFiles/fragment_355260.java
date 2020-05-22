if (n1 >= n2) {
    if (n1 >= n3) {
        if (n2 >= n3) {
            System.out.printf("%d, %d, %d", n1, n2, n3);
        } else {
            System.out.printf("%d, %d, %d", n1, n3, n2);
        }
    } else {
        if (n2 >= n3) {
            System.out.printf("%d, %d, %d", n2, n3, n1);
        } else {
            System.out.printf("%d, %d, %d", n3, n1, n2);
        }
    }
} else {
    if (n1 >= n3) {
        if (n2 >= n3) {
            System.out.printf("%d, %d, %d", n2, n1, n3);
        } else {
            System.out.printf("%d, %d, %d", n3, n2, n1);
        }
    } else {
        if (n2 >= n3) {
            System.out.printf("%d, %d, %d", n2, n3, n1);
        } else {
            System.out.printf("%d, %d, %d", n3, n2, n1);
        }
    }
}
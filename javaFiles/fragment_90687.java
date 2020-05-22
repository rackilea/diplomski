int n = 6;
    int num = 0;
    int step = 1;

    for (int i = 1; i <= n; i++) {
        // num : (i² - i + 2)/2 .. same + i - 1
        for (int j = 0; j < i; j++) {
            num += step;
            System.out.print(num);
            System.out.print(' ');
        }
        num += i + (1 + 3*step)/2;
        step = -step; // zig resp. zag
        System.out.println();
    }
for (int i = 0; i < firstArr.length; i++) {
    boolean matches = true;
    for (int j = 0; j < firstArr.length; j++) {
        if (firstArr[j] != secondArr[(i + j) % firstArr.length]) {
            matches = false;
            break;
        }
    }
    if (matches) {
        System.out.println(args[0] + ", " + args[1] + " 1 => " + i);
    }
}
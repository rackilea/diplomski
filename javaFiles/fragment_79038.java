while (true) {
    final String code = scan.next();
    if (isExitCode(code)) {
        break;
    }
    if (!isValidCode(code)) {
        System.out.println("Invalid code, please enter valid code.");
        continue;
    }
    int quantity = -1;
    while (true) {
        quantity = scan.nextInt();
        if (!isValidQuantity(quantity)) {
            System.out.println("bad quantity");
            continue;
        }
        break;
    }
    // if you've got here, you have a valid code and a valid 
    // quantity; deal with it as you see fit.
}
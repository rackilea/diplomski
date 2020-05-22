while (true) {
    System.out.print("Please enter an operation: ");
    oper = input.next().charAt(0);

    if ("+*/-%".indexOf(oper) != -1) {
        break;
    }
}
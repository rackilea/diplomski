while (scan.hasNextLine()) {
    String nextInput = scan.nextLine();
    stack.push(nextInput );
    if (nextInput.equals(" ")) {
        break;
    }
}
while (true) {
    in.read(bin);
    if (bin[0] == '^') { // or something like that
        break;
    }
    System.out.print(bin);
    bin = new char[400];
}
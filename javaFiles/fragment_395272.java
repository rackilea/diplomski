for (int a = 0; ; a++) {
    e = (char) System.in.read();
    if (e == '\n')
        continue;
    if (e == 49)
        break;
    else
        System.out.println("Use number lower than 9");
}
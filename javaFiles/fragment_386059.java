int i=0;
while (true) {
    try {
        test();
        break;
    } catch (Exception e) {
        i++; // Loop will continue
    }
}
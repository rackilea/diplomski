for (int j = 7; j >= 0; --j) {
    if ((x & (1 << j)) != 0) {
        IO.print("1");
    } else {
        IO.print("0");
    }
}
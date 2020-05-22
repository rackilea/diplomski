static int readInt() throws IOException {
    int num = 0, ch;
    while ((ch = System.in.read()) > 0)
        if (ch > ' ')
            break;
    if (ch < 0)
        return -1;
    do {
        num = num * 10 + ch - '0';
        ch = System.in.read();
    } while (ch > ' ');
    return num;
}

static void writeInt(int i) {
    if (i == 0) {
        System.out.write('0');
        System.out.write('\n');
        return;
    } else if (i < 0) {
        System.out.write('-');
        writeInt(-i);
        return;
    }
    int tens = 1000000000;
    for (; tens > i; tens /= 10) ;
    for (; tens > 0; tens /= 10)
        System.out.write((char) ('0' + i / tens % 10));
    System.out.write('\n');
}

public static void main(String... args) throws IOException {
    int count = readInt();
    for (int i = 0; i < count; i++) {
        int pushPop = readInt();
        switch (pushPop) {
            case -1: // OEF
                return;
            case 36074: // PUSH
            case 71626: // push
                push(readInt(), readInt());
                break;

            case 3542: // PUSH
            case 7094: // pop
                writeInt(pop(readInt()));
                break;
        }
    }
}
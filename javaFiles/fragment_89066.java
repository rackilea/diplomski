private int doSomethingWithTHESEChannels(int i, int channels) {

    if (Channel.NONE == channels) {
        return i;
    }

    int a, r, g, b;
    a = (i & Channel.ALPHA) >> 24;
    r = (i & Channel.RED) >> 16;
    g = (i & Channel.GREEN) >> 8;
    b = i & Channel.BLUE;

    int cur = channels & Channel.ALL;
    if (cur == Channel.ALL) {
        System.out.println("all found");
        a = transform(a);
        r = transform(r);
        g = transform(g);
        b = transform(b);

    } else {
        cur = channels & Channel.ALPHA;
        if (cur == Channel.ALPHA) {
            System.out.println("alpha found");
            a = transform(a);
        }
        cur = channels & Channel.RED;
        if (cur == Channel.RED) {
            System.out.println("red found");
            r = transform(r);
        }
        cur = channels & Channel.GREEN;
        if (cur == Channel.GREEN) {
            System.out.println("green found");
            g = transform(g);
        }

        cur = channels & Channel.BLUE;
        if (cur == Channel.BLUE) {
            System.out.println("blue found");
            b = transform(b);
        }

    }

    return (a << 24 | r << 16 | g << 8 | b);

}
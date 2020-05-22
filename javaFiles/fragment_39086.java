public static int XScale = 865;

static {
    switch (scale) {
    case 0:
        XScale = 405;
        break;
    case 1:
        XScale = 1835;
        break;
    case 3:
        XScale = 565;
        break;
    }
}
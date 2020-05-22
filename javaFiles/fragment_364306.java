static {
    x = 10; //this works
}
static int x;

static {
    z = y; //illegal forward reference error.
}
static int y;
static int z;
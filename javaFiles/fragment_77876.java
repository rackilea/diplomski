int x = a + n;
int y = b + n;
int result = Math.min(tree[x], tree[y]);

while (x / 2 != y / 2) {
    if (x % 2 == 0) {
      result = Math.min(result, tree[x + 1]);
    }
    if (y % 2 == 1) {
      result = Math.min(result, tree[y - 1]);
    }

    x /= 2;
    y /= 2;
}
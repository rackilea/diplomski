String data = "";
int count = 0;
for (int i = 0; i < n; i++) {
    if (sc.hasNext()) {
        data = sc.next();
        count = 0;
    } else {
        break;
    }
    for (int j = 0; j < n; j++)
    map[i][j] = data.charAt(count++);
}
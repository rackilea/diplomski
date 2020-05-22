function partition(n, m) {
    if (m < 2) return m;
    if (n < m) return 0;
    if (n <= m + 1) return 1;
    var max = Math.floor(n / m);
    if (m == 2) return max;
    var count = 0;
    for (; max--; n -= m) count += partition(n - 1, m - 1);
    return count;
}

document.write(partition(6, 1) + "<br>");    // 1
document.write(partition(6, 2) + "<br>");    // 3
document.write(partition(9, 3) + "<br>");    // 7
document.write(partition(16, 4) + "<br>");   // 34
document.write(partition(150, 75) + "<br>"); // 8,118,264
// document.write(partition(150, 23));       // 1,901,740,434 (maximum for 150, takes > 10s)
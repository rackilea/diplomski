function partition(n, m) {
    if (m < 2) return m;
    if (n < m) return 0;
    var memo = [];
    for (var i = 0; i < n - 1; i++) memo[i] = [];
    return p(n, m);

    function p(n, m) {
        if (n <= m + 1) return 1;
        if (memo[n - 2][m - 2]) return memo[n - 2][m - 2];
        var max = Math.floor(n / m);
        if (m == 2) return max;
        var count = 0;
        for (; max--; n -= m) count += (memo[n - 3][m - 3] = p(n - 1, m - 1));
        return count;
    }
}

document.write(partition(150, 23) + "<br>");  // 1,901,740,434
// document.write(partition(1000, 81));       // 4.01779428811641e+29
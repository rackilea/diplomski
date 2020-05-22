for (int i = pl.x; i < pl.x + pl.l; i++)
    counts[pl.y][i]--;
for (int i = pl.x; i < pl.x + pl.l; i++)
    if (counts[pl.y][i] == 0)
        c[pl.y][i] = '_';
// can also just use a single loop with "if (--counts[pl.y][i] == 0)"
String single[][];
single = new String[(m * m)][];
for (int i = 0; i < (m); i++) {
    for (int b = 0; b <= m; b++) {
        single[i*m+b] = (grid[i].split("(?!^)"));
        System.out.println(p);
    }
}
displayPathtoPrincess(m, grid);
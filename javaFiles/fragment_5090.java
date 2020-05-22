// Folder 0: 1-500
// Folder 1: 501-1000
// Folder 2: 1001-1500
// ...

int n = 1777;
int folder = (n-1) / 500;

System.out.printf("%d belongs to folder %d - %d",
                  n, folder * 500 + 1, (folder+1) * 500);
char[][] table = new char[20][20]

for(int i = 0; i < 20; i++) {
    for(int j = 0; j < 20; j++) {
        int surroundingBacteria = 0;
        for(int x = max(i-1,0); x < min(20,i+1); x++) {
            for(int y = max(i-1,0); y < min(20,i+1); y++) {
                if(table[x][y] == '*') surroundingBacteria++;
            }
        }
        switch(surroundingBacteria) {
            // put your case logic here
        }
    }
}
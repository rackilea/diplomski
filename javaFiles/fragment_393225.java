int numberOfLines = 4;
int numberOfDigitsPerLine = 5;

for (int i=1; i<numberOfLines+1; i++){
    for(int j=1; j<=numberOfDigitsPerLine; j++) {
        if(j>=i) {
            System.out.print(j);
        } else {
            System.out.print(i);
        }
    }
    System.out.println();
}
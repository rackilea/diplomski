int j;
int b;

for(int i=0;i<20-1;i++){
    int minIndex=i;

    for(j=i+1;j<20; j++) {
        b=(bookA[j].getTitle().compareTo(bookA[minIndex].getTitle()));
        if(b<0){
            minIndex=j;
        }
    }

    Book temp = bookA[i];
    bookA[i] = bookA[minIndex];
    bookA[minIndex] = temp;
}

for(int z=0;z<20;z++)
    System.out.println(bookA[z].toString());
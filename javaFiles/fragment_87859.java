Slumbook[] slum = new Slumbook[20];

for(int i = 0 ; i < slum.length ; i++)  //initializing all the elements
    slum[i] = new Slumbook();

for(int n=0; n<10; n++){
    slum[n].setCodeName(sc.nextLine());
}
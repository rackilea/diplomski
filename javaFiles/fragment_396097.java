int  rand1 = (int) (Math.random() * nameLength);
int  rand2 = (int) (Math.random() * actionLength);
int  rand3 = (int) (Math.random() * nameLength);
while(rand1==rand3){
    rand3 = (int) (Math.random() * nameLength);
}
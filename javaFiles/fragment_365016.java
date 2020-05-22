int j=0;
int i= 0;

while(j<Reihe.length){
    zahl = (int) (Math.random()*50);
    boolean schonda = false;
    while ( i<j){
        if(Reihe[i]== zahl) 
            schonda=true;
        i++;
    }

    if(schonda==false && zahl !=0){
        Reihe[j]=zahl;
        j++;
    }
}
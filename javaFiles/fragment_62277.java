int j = 0;
for(int i = 0; i<perro.length; i++){
    if(i == newIndex){
        perro[i] = newNumber;
    }
    else{
        perro[i] = gato[j];
        j++;
    }
}
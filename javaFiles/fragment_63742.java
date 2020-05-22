String animals[] = {"Dog","Cat","Cow"};
String hashAnimals[] = {"1", null, null, "4", null, null};
int index =5;
for(int j=0; j<animals.length; j++) {
    for(int i=0; i<hashAnimals.length; i++) {
        if(index == hashAnimals.length) {
            index = 0;
        }
        if(hashAnimals[index] == null){
            hashAnimals[index] = animals[j];
            index++;
            break;
        }
        index++;
    }
}
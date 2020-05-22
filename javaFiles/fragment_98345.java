for(ObjectA objA : arrayListOfObjectAs){
    int id = objA.id;
    for(ObjectB objB : arrayListOfObjectBs){
        if(id == objB.objAId){
            //do what you want with the objB.discountValue here
        break;
        }
    }
}
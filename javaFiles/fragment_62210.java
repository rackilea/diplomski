synchronized(dustList){
    int numSpecs = 400;
    for (int i = 0; i < numSpecs; i++) { 
        SpaceDust spec = new SpaceDust(screenX, screenY); 
        dustList.add(spec); 
    } 
}
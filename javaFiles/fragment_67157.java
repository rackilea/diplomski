Data klasseObject = new Data();
klasseObject.infoListe(); 

Data klasseObject2 = new Data(); 
klasseObject.infoListe(); 

Data klasseObject3 = new Data(); 
klasseObject.infoListe(); 

for(Ansat s: klasseObject.getAnsat()) 
    System.out.println(s.toString());
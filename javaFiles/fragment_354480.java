for (Object document : DataSentFromServer) {  
    try{                                 
       MyObjectClassArrayList.add(document.toObject(MyObject.class));
    }catch(RuntimeException e){
      //do something with the bad data if you wish.
    }
}
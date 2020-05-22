Query query=firestoredb.collection("items"); 
 if(PRICE.equals("price")) {
      query = query.orderby('price'); 
 }
 if(NAME.equals("name")) {
      query = query.orderby('name'); 
 }
 if("itemCategory"){
      query = query.orderby('itemCategory');
 }